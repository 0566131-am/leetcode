class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = x; i < x + k / 2; i++) {
            int i2 = x + k - 1 - (i - x); // corresponding bottom row
            
            for (int j = y; j < y + k; j++) {
                // swap elements
                int temp = grid[i][j];
                grid[i][j] = grid[i2][j];
                grid[i2][j] = temp;
            }
        }
        return grid;
    }
}