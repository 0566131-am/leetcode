import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // value -> sorted indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();

        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            // Only one occurrence
            if (list.size() == 1) {
                res.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(list, q);
            int size = list.size();

            int minDist = Integer.MAX_VALUE;

            // check previous
            int prev = list.get((idx - 1 + size) % size);
            int dist1 = Math.abs(q - prev);
            dist1 = Math.min(dist1, n - dist1);

            // check next
            int next = list.get((idx + 1) % size);
            int dist2 = Math.abs(q - next);
            dist2 = Math.min(dist2, n - dist2);

            minDist = Math.min(dist1, dist2);

            res.add(minDist);
        }

        return res;
    }
}