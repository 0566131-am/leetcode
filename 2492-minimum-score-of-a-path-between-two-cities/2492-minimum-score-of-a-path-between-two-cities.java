import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        // 1. Build the adjacency list
        // Each node maps to a list of pairs: [neighbor, distance]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            graph.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }
        
        // 2. BFS to traverse the connected component starting from city 1
        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            // Check all edges connected to the current node
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int distance = neighbor[1];
                    
                    // Update the minimum score seen in this component
                    minScore = Math.min(minScore, distance);
                    
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        queue.offer(nextNode);
                    }
                }
            }
        }
        
        return minScore;
    }
}