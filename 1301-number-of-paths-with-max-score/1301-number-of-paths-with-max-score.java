class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;
        
        // dp[i][j] stores the max score from 'S' to (i, j)
        int[][] dp = new int[n][n];
        // count[i][j] stores the number of paths with that max score
        int[][] count = new int[n][n];
        
        // Base case: at starting point 'S'
        count[n - 1][n - 1] = 1;
        
        // Directions to look from: down, right, down-right diagonal
        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};
        
        // Iterate backwards from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Skip the start cell since it's already initialized
                if (i == n - 1 && j == n - 1) continue;
                
                char c = board.get(i).charAt(j);
                // Skip obstacles
                if (c == 'X') continue;
                
                int maxScore = -1;
                int paths = 0;
                
                // Check all 3 incoming valid cells
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    
                    // If neighbor is valid and reachable
                    if (ni < n && nj < n && count[ni][nj] > 0) {
                        if (dp[ni][nj] > maxScore) {
                            maxScore = dp[ni][nj];
                            paths = count[ni][nj];
                        } else if (dp[ni][nj] == maxScore) {
                            paths = (paths + count[ni][nj]) % MOD;
                        }
                    }
                }
                
                // If this cell is reachable from at least one valid path
                if (maxScore != -1) {
                    int currentVal = (c == 'E') ? 0 : (c - '0');
                    dp[i][j] = maxScore + currentVal;
                    count[i][j] = paths;
                }
            }
        }
        
        return new int[]{dp[0][0], count[0][0]};
    }
}