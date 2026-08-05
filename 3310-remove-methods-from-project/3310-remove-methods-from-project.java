import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] inv : invocations) {
            adj.get(inv[0]).add(inv[1]);
        }

        // Step 2: Find all suspicious methods via DFS starting from k
        boolean[] isSuspicious = new boolean[n];
        dfs(k, adj, isSuspicious);

        // Step 3: Check if any non-suspicious node invokes a suspicious node
        boolean cannotRemove = false;
        for (int[] inv : invocations) {
            int u = inv[0];
            int v = inv[1];
            if (!isSuspicious[u] && isSuspicious[v]) {
                cannotRemove = true;
                break;
            }
        }

        // Step 4: Build the result list
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cannotRemove || !isSuspicious[i]) {
                result.add(i);
            }
        }

        return result;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] isSuspicious) {
        isSuspicious[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!isSuspicious[neighbor]) {
                dfs(neighbor, adj, isSuspicious);
            }
        }
    }
}