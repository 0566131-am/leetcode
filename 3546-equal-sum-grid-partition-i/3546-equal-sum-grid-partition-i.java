class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;

        // Calculate total sum
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        // If total sum is odd, can't split equally
        if (total % 2 != 0) return false;

        int m = grid.length, n = grid[0].length;

        // Check horizontal cuts
        long prefix = 0;
        for (int i = 0; i < m; i++) {
            for (int val : grid[i]) {
                prefix += val;
            }
            if (prefix * 2 == total && i < m - 1) {
                return true;
            }
        }

        // Check vertical cuts
        prefix = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                prefix += grid[i][j];
            }
            if (prefix * 2 == total && j < n - 1) {
                return true;
            }
        }

        return false;
    }
}