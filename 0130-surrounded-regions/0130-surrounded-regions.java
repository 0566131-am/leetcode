class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return; 
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < Math.max(rows, cols); i++) {
            if (i < cols) {
                if (board[0][i] == 'O') dfs(board, 0, i);   
                if (board[rows - 1][i] == 'O') dfs(board, rows - 1, i); 
            }
            if (i < rows) {
                if (board[i][0] == 'O') dfs(board, i, 0); 
                if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1); 
            }
        }    
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'E') {
                    board[r][c] = 'O'; 
                }
            }
        }
    }
    
    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'E';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c); 
        dfs(board, r, c - 1); 
        dfs(board, r, c + 1); 
    }
}