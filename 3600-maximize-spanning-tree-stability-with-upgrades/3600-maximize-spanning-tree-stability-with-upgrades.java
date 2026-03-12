import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left = 0, right = 0;

        for (int[] e : edges)
            right = Math.max(right, e[2] * 2);

        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);
        int usedEdges = 0;

        List<int[]> optional = new ArrayList<>();

        // Step 1: process mandatory edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2], must = e[3];

            if (must == 1) {

                if (w < target) return false;

                if (!dsu.union(u, v)) return false; // cycle in mandatory edges

                usedEdges++;
            } else {
                optional.add(e);
            }
        }

        List<int[]> upgradeCandidates = new ArrayList<>();

        // Step 2: optional edges without upgrade
        for (int[] e : optional) {
            int u = e[0], v = e[1], w = e[2];

            if (w >= target) {
                if (dsu.union(u, v)) usedEdges++;
            } else if (w * 2 >= target) {
                upgradeCandidates.add(e);
            }
        }

        int upgrades = 0;

        // Step 3: use upgrades if needed
        for (int[] e : upgradeCandidates) {

            if (usedEdges == n - 1) break;
            if (upgrades >= k) break;

            int u = e[0], v = e[1];

            if (dsu.union(u, v)) {
                usedEdges++;
                upgrades++;
            }
        }

        return usedEdges == n - 1;
    }
}