class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zeroCount = 0;
        int startX = 0, startY = 0;
        
        // Scan the grid to locate the start position and count walkable squares
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    zeroCount++;
                } else if (grid[r][c] == 1) {
                    startX = r;
                    startY = c;
                }
            }
        }
        
        // We add 1 to zeroCount because the starting square also needs to be counted 
        // as part of the total path length remaining.
        return backtrack(grid, startX, startY, zeroCount + 1);
    }
    
    private int backtrack(int[][] grid, int r, int c, int remain) {
        // Boundary check and obstacle check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1) {
            return 0;
        }
        
        // Target check: If we reach the end square
        if (grid[r][c] == 2) {
            // Valid only if we have stepped on every required cell
            return remain == 0 ? 1 : 0;
        }
        
        // Mark the current cell as visited by setting it to an obstacle
        int temp = grid[r][c];
        grid[r][c] = -1;
        
        // Explore all 4 directions
        int paths = 0;
        paths += backtrack(grid, r + 1, c, remain - 1); // Down
        paths += backtrack(grid, r - 1, c, remain - 1); // Up
        paths += backtrack(grid, r, c + 1, remain - 1); // Right
        paths += backtrack(grid, r, c - 1, remain - 1); // Left
        
        // Unmark the current cell (Backtrack)
        grid[r][c] = temp;
        
        return paths;
    }
}