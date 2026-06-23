class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        int numValues = r - l + 1;
        
        // Base case: if n = 1, any single element is valid, but no direction is established.
        // However, constraints say 3 <= n <= 2000.
        
        // dp[0][x] -> ending at x, next move must be DOWN (0)
        // dp[1][x] -> ending at x, next move must be UP (1)
        long[][] dp = new long[2][numValues];
        
        // Initialize for length 2
        for (int y = 0; y < numValues; y++) {
            dp[0][y] = y;              // values smaller than y (0 to y-1)
            dp[1][y] = numValues - 1 - y;  // values larger than y (y+1 to numValues-1)
        }
        
        // Transition for lengths from 3 up to n
        for (int len = 3; len <= n; len++) {
            long[][] nextDp = new long[2][numValues];
            
            // Prefix sum of dp[1] to optimize nextDp[0]
            long[] pref1 = new long[numValues];
            long currentSum1 = 0;
            for (int x = 0; x < numValues; x++) {
                currentSum1 = (currentSum1 + dp[1][x]) % MOD;
                pref1[x] = currentSum1;
            }
            
            // Suffix sum of dp[0] to optimize nextDp[1]
            long[] suff0 = new long[numValues];
            long currentSum0 = 0;
            for (int x = numValues - 1; x >= 0; x--) {
                currentSum0 = (currentSum0 + dp[0][x]) % MOD;
                suff0[x] = currentSum0;
            }
            
            // Calculate transitions
            for (int y = 0; y < numValues; y++) {
                // nextDp[0][y] = sum of dp[1][x] for x < y
                if (y > 0) {
                    nextDp[0][y] = pref1[y - 1];
                }
                // nextDp[1][y] = sum of dp[0][x] for x > y
                if (y < numValues - 1) {
                    nextDp[1][y] = suff0[y + 1];
                }
            }
            
            dp = nextDp;
        }
        
        // Sum up all valid sequences of length n
        long totalWays = 0;
        for (int x = 0; x < numValues; x++) {
            totalWays = (totalWays + dp[0][x] + dp[1][x]) % MOD;
        }
        
        return (int) totalWays;
    }
}