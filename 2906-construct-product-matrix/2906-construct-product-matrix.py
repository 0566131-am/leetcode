class Solution:
    def constructProductMatrix(self, grid):
        MOD = 12345
        m, n = len(grid), len(grid[0])
        
        # Flatten grid
        arr = []
        for row in grid:
            arr.extend(row)
        
        size = len(arr)
        
        # Prefix
        prefix = [1] * size
        for i in range(1, size):
            prefix[i] = (prefix[i-1] * arr[i-1]) % MOD
        
        # Suffix
        suffix = [1] * size
        for i in range(size-2, -1, -1):
            suffix[i] = (suffix[i+1] * arr[i+1]) % MOD
        
        # Result array
        res = [(prefix[i] * suffix[i]) % MOD for i in range(size)]
        
        # Convert back to 2D
        result = []
        idx = 0
        for i in range(m):
            row = []
            for j in range(n):
                row.append(res[idx])
                idx += 1
            result.append(row)
        
        return result