import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        
        // Build adjacency list for the DAG
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj[u].add(new int[]{v, cost});
            minCost = Math.min(minCost, cost);
            maxCost = Math.max(maxCost, cost);
        }
        
        // Calculate in-degrees for topological sort
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        
        // Generate topological order of the DAG
        List<Integer> topoOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);
            for (int[] edge : adj[u]) {
                int v = edge[0];
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        // Binary search for the maximum possible minimum edge cost
        int low = minCost, high = maxCost;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(n, adj, topoOrder, online, k, mid)) {
                ans = mid;
                low = mid + 1; // Try to maximize the minimum edge weight
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int n, List<int[]>[] adj, List<Integer> topoOrder, boolean[] online, long k, int minEdgeThreshold) {
        // dp[i] will store the minimum cost to reach node i from node 0
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        
        for (int u : topoOrder) {
            if (dp[u] == Long.MAX_VALUE) continue;
            
            // If the current intermediate node is offline, we cannot move further from it
            if (u != 0 && u != n - 1 && !online[u]) continue;
            
            for (int[] edge : adj[u]) {
                int v = edge[0];
                int cost = edge[1];
                
                // Only traverse if the edge cost is at least our binary search threshold
                if (cost >= minEdgeThreshold) {
                    if (dp[u] + cost < dp[v]) {
                        dp[v] = dp[u] + cost;
                    }
                }
            }
        }
        
        return dp[n - 1] <= k;
    }
}