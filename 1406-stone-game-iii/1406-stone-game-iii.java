class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        // dp array storing max score difference from index i to end.
        // We use size 4 to store dp[i+1], dp[i+2], dp[i+3] easily.
        int[] dp = new int[4]; 

        for (int i = n - 1; i >= 0; i--) {
            int takeStones = 0;
            int maxDiff = Integer.MIN_VALUE;

            for (int k = 0; k < 3 && i + k < n; k++) {
                takeStones += stoneValue[i + k];
                // Difference = current pick sum - max difference opponent can get next
                int diff = takeStones - dp[(i + k + 1) % 4];
                maxDiff = Math.max(maxDiff, diff);
            }

            dp[i % 4] = maxDiff;
        }

        int aliceDiff = dp[0];
        if (aliceDiff > 0) return "Alice";
        if (aliceDiff < 0) return "Bob";
        return "Tie";
    }
}