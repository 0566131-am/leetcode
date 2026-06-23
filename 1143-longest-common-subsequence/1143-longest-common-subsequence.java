class Solution {
    private Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        memo = new Integer[m][n];
        
        return backtracking(text1, text2, 0, 0);
    }

    private int backtracking(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + backtracking(text1, text2, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(
                backtracking(text1, text2, i + 1, j), 
                backtracking(text1, text2, i, j + 1)
            );
        }

        return memo[i][j];
    }
}