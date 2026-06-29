class Solution:
    def findTheCity(self, n: int, edges: list[list[int]], distanceThreshold: int) -> int:
        # Step 1: Initialize the distance matrix with infinity
        # (Use list comprehension to avoid shallow copy/reference issues)
        dist = [[float('inf')] * n for _ in range(n)]
        
        # Distance from a city to itself is 0
        for i in range(n):
            dist[i][i] = 0
            
        # Populate initial reachable edges
        for u, v, w in edges:
            dist[u][v] = w
            dist[v][u] = w
            
        # Step 2: Floyd-Warshall Algorithm to find all-pairs shortest paths
        for via in range(n):
            for i in range(n):
                for j in range(n):
                    if dist[i][via] + dist[via][j] < dist[i][j]:
                        dist[i][j] = dist[i][via] + dist[via][j]
                        
        # Step 3: Count reachable cities and find the optimal city
        min_reachable_count = n
        best_city = -1
        
        for i in range(n):
            reachable_count = 0
            for j in range(n):
                if i != j and dist[i][j] <= distanceThreshold:
                    reachable_count += 1
            
            # Using '<=' automatically updates to a greater city ID 
            # in case of a tie because we are iterating from 0 to n-1
            if reachable_count <= min_reachable_count:
                min_reachable_count = reachable_count
                best_city = i
                
        return best_city