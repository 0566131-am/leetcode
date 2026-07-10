import java.util.Arrays;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // 1. Sort indices based on their values in nums
        Integer[] sortedIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedIndices[i] = i;
        }
        Arrays.sort(sortedIndices, (a, b) -> Integer.compare(nums[a], nums[b]));

        // To map original index to its position in the sorted array
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[sortedIndices[i]] = i;
        }

        // 2. Compute the immediate greedy jump for each sorted position
        // nextJump[i] stores the furthest index j (j >= i) such that nums[sortedIndices[j]] - nums[sortedIndices[i]] <= maxDiff
        int[] nextJump = new int[n];
        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right + 1 < n && nums[sortedIndices[right + 1]] - nums[sortedIndices[left]] <= maxDiff) {
                right++;
            }
            nextJump[left] = right;
        }

        // 3. Build the Sparse Table for Binary Lifting
        int LOG = 18; // since n <= 10^5, 2^17 = 131072
        int[][] up = new int[n][LOG];
        for (int i = 0; i < n; i++) {
            up[i][0] = nextJump[i];
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        // 4. Process Queries
        int numQueries = queries.length;
        int[] ans = new int[numQueries];

        for (int q = 0; q < numQueries; q++) {
            int u = queries[q][0];
            int v = queries[q][1];

            if (u == v) {
                ans[q] = 0;
                continue;
            }

            int rU = rank[u];
            int rV = rank[v];

            // Ensure rU is the smaller value to jump towards the larger value rV
            if (rU > rV) {
                int temp = rU;
                rU = rV;
                rV = temp;
            }

            // Verify if rV is even reachable at all in the connected component
            // We find the absolute maximum reachable index from rU using maximum jumps
            int maxReachable = rU;
            for (int j = LOG - 1; j >= 0; j--) {
                maxReachable = up[maxReachable][j];
            }
            
            if (maxReachable < rV) {
                ans[q] = -1;
                continue;
            }

            // Binary lift to find the exact minimum steps to reach or cover rV
            int steps = 0;
            int curr = rU;
            for (int j = LOG - 1; j >= 0; j--) {
                if (up[curr][j] < rV) {
                    curr = up[curr][j];
                    steps += (1 << j);
                }
            }

            // One more jump is needed to finally reach or cross rV
            ans[q] = steps + 1;
        }

        return ans;
    }
}