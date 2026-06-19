class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Try starting the search from every cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base Case: If we matched all characters in the word
        if (index == word.length()) {
            return true;
        }
        
        // Boundary check and character match check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // Save the current character and mark the cell as visited
        char temp = board[r][c];
        board[r][c] = '#'; 
        
        // Explore all 4 adjacent directions
        boolean found = dfs(board, word, r + 1, c, index + 1) || // Down
                        dfs(board, word, r - 1, c, index + 1) || // Up
                        dfs(board, word, r, c + 1, index + 1) || // Right
                        dfs(board, word, r, c - 1, index + 1);   // Left
        
        // Unmark the cell (Backtrack)
        board[r][c] = temp;
        
        return found;
    }
}