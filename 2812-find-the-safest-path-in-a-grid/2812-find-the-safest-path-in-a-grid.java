import java.util.*;

class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        // Step 1: Multi-Source BFS to compute distance to the nearest thief for each cell
        int[][] dist = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.offer(new int[]{r, c});
                    dist[r][c] = 0;
                } else {
                    dist[r][c] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 2: Priority Queue (Max-Heap) to maximize the path's min safeness factor
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        maxHeap.offer(new int[]{dist[0][0], 0, 0});

        int[][] maxSafeness = new int[n][n];
        for (int[] row : maxSafeness) {
            Arrays.fill(row, -1);
        }
        maxSafeness[0][0] = dist[0][0];

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int safeness = curr[0], r = curr[1], c = curr[2];

            // Reached destination
            if (r == n - 1 && c == n - 1) {
                return safeness;
            }

            if (safeness < maxSafeness[r][c]) continue;

            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int nextSafeness = Math.min(safeness, dist[nr][nc]);
                    if (nextSafeness > maxSafeness[nr][nc]) {
                        maxSafeness[nr][nc] = nextSafeness;
                        maxHeap.offer(new int[]{nextSafeness, nr, nc});
                    }
                }
            }
        }

        return 0;
    }
}