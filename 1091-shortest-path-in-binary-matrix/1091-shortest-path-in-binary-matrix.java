import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // Corner case: If the start or end cell is blocked, a clear path is impossible.
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        
        // Handle the single-cell matrix case grid = [[0]]
        if (n == 1) {
            return 1;
        }
        
        // Define all 8 possible directions (rowOffset, colOffset)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
             {0, -1},           {0, 1},
             {1, -1},  {1, 0},  {1, 1}
        };
        
        // Queue stores the coordinates of the cells: {row, col}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        // Track the length of the path. Start cell counts as 1.
        int pathLength = 1;
        
        // Mark the start cell as visited right away to prevent adding it again
        grid[0][0] = 1; 
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all cells at the current path depth level
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                
                // If we reached the bottom-right cell, return the path length
                if (r == n - 1 && c == n - 1) {
                    return pathLength;
                }
                
                // Check all 8-directional neighbors
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    // Validate boundary conditions and make sure the cell is 0 (empty/unvisited)
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        // Quick optimization check: if this neighbor is the destination, we can exit early!
                        if (nr == n - 1 && nc == n - 1) {
                            return pathLength + 1;
                        }
                        
                        queue.offer(new int[]{nr, nc});
                        grid[nr][nc] = 1; // Mark as visited immediately when pushing to the queue
                    }
                }
            }
            pathLength++;
        }
        
        return -1; // Destination is unreachable
    }
}