import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // 1. Build the adjacency list and track vertex degrees
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        
        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;
        
        // 2. Iterate through all vertices to find connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] counts = new int[2]; // counts[0] = vertexCount, counts[1] = edgeDegreeSum
                dfs(i, adj, degree, visited, counts);
                
                int vCount = counts[0];
                int totalEdgesInComponent = counts[1] / 2;
                
                // 3. Check completeness condition: E == V * (V - 1) / 2
                if (totalEdgesInComponent == (vCount * (vCount - 1)) / 2) {
                    completeComponentsCount++;
                }
            }
        }
        
        return completeComponentsCount;
    }
    
    private void dfs(int node, List<List<Integer>> adj, int[] degree, boolean[] visited, int[] counts) {
        visited[node] = true;
        counts[0]++;             // Increment vertex count
        counts[1] += degree[node]; // Accumulate degree sum
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, degree, visited, counts);
            }
        }
    }
}