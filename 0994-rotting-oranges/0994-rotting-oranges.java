import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int freshOranges = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.offer(r * cols + c);
                else if (grid[r][c] == 1) freshOranges++;
            }
        }
        
        if (freshOranges == 0) return 0;
        
        int minutes = 0;
        int[] dirs = {-1, 0, 1, 0, -1}; 
        while (!queue.isEmpty() && freshOranges > 0) {
            minutes++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int code = queue.poll();
                int r = code / cols; 
                int c = code % cols; 

                for (int d = 0; d < 4; d++) {
                    int nr = r + dirs[d];
                    int nc = c + dirs[d + 1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshOranges--;
                        queue.offer(nr * cols + nc);
                    }
                }
            }
        }
        
        return freshOranges == 0 ? minutes : -1;
    }
}