import heapq

class Solution:
    def minimumEffortPath(self, heights: list[list[int]]) -> int:
        rows, cols = len(heights), len(heights[0])
        efforts = [[float('inf')] * cols for _ in range(rows)]
        efforts[0][0] = 0
        
        pq = [(0, 0, 0)]
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        while pq:
            current_effort, r, c = heapq.heappop(pq)
            
            if r == rows - 1 and c == cols - 1:
                return current_effort
                
            if current_effort > efforts[r][c]:
                continue
                
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                
                if 0 <= nr < rows and 0 <= nc < cols:
                    jump_effort = abs(heights[r][c] - heights[nr][nc])
                    next_effort = max(current_effort, jump_effort)
                    
                    if next_effort < efforts[nr][nc]:
                        efforts[nr][nc] = next_effort
                        heapq.heappush(pq, (next_effort, nr, nc))
                        
        return 0