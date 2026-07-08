import java.util.*;

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1_000_000_007L;
        
        // Collect all non-zero digits and their original indices
        List<Integer> positions = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                positions.add(i);
                digits.add(ch - '0');
            }
        }
        
        int n = digits.size();
        long[] prefVal = new long[n + 1];
        long[] prefSum = new long[n + 1];
        long[] pow10 = new long[n + 1];
        
        pow10[0] = 1;
        for (int i = 0; i < n; i++) {
            prefVal[i + 1] = (prefVal[i] * 10 + digits.get(i)) % MOD;
            prefSum[i + 1] = prefSum[i] + digits.get(i);
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }
        
        int numQueries = queries.length;
        int[] answer = new int[numQueries];
        
        for (int i = 0; i < numQueries; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
            // Find the range of non-zero digits within [l, r]
            int a = findFirstGreaterOrEqual(positions, l);
            int b = findLastLessOrEqual(positions, r);
            
            if (a > b || a == positions.size() || b == -1) {
                answer[i] = 0;
            } else {
                // Extract x % MOD
                long len = b - a + 1;
                long x = (prefVal[b + 1] - (prefVal[a] * pow10[(int)len]) % MOD + MOD) % MOD;
                
                // Extract sum of digits
                long sum = prefSum[b + 1] - prefSum[a];
                
                answer[i] = (int)((x * (sum % MOD)) % MOD);
            }
        }
        
        return answer;
    }
    
    // Lower bound binary search
    private int findFirstGreaterOrEqual(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        int ans = list.size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    // Upper bound binary search
    private int findLastLessOrEqual(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}