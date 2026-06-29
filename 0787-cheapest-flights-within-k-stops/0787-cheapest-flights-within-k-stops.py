from collections import deque

class Solution:
    def findCheapestPrice(self, n: int, flights: list[list[int]], src: int, dst: int, k: int) -> int:
        # Step 1: Build the adjacency list for the graph
        graph = [[] for _ in range(n)]
        for u, v, price in flights:
            graph[u].append((v, price))
            
        # Step 2: Track the minimum prices to reach each city
        prices = [float('inf')] * n
        prices[src] = 0
        
        # Queue stores tuples of (current_city, current_cost)
        queue = deque([(src, 0)])
        stops = 0
        
        # Step 3: BFS level by level up to k + 1 flights
        while queue and stops <= k:
            # Level-size tracking ensures we process one complete "stop" layer at a time
            level_size = len(queue)
            
            for _ in range(level_size):
                curr_city, curr_cost = queue.popleft()
                
                # Explore neighbors
                for neighbor, price in graph[curr_city]:
                    next_cost = curr_cost + price
                    
                    # Optimization: Only proceed if this path is cheaper than 
                    # any previously recorded path to this neighbor
                    if next_cost < prices[neighbor]:
                        prices[neighbor] = next_cost
                        queue.append((neighbor, next_cost))
            
            stops += 1
            
        # Return the final cheapest price to dst if reachable, else -1
        return prices[dst] if prices[dst] != float('inf') else -1