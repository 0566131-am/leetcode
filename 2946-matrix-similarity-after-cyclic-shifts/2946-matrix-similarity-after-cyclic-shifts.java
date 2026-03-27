class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k % n; // reduce unnecessary rotations

        for (int i = 0; i < m; i++) {
            int[] row = mat[i];

            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    // even row → left shift
                    if (row[j] != row[(j + k) % n]) {
                        return false;
                    }
                } else {
                    // odd row → right shift
                    if (row[j] != row[(j - k + n) % n]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}