class Solution:
    def findTheString(self, lcp):
        n = len(lcp)
        
        # Step 1: Validate diagonal and symmetry
        for i in range(n):
            if lcp[i][i] != n - i:
                return ""
            for j in range(n):
                if lcp[i][j] != lcp[j][i]:
                    return ""
        
        # Step 2: Build string
        s = ['?'] * n
        curr_char = 'a'
        
        for i in range(n):
            if s[i] == '?':
                if curr_char > 'z':
                    return ""
                for j in range(i, n):
                    if lcp[i][j] > 0:
                        s[j] = curr_char
                curr_char = chr(ord(curr_char) + 1)
        
        s = ''.join(s)
        
        # Step 3: Verify LCP
        dp = [[0] * n for _ in range(n)]
        
        for i in reversed(range(n)):
            for j in reversed(range(n)):
                if s[i] == s[j]:
                    if i == n - 1 or j == n - 1:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = 1 + dp[i+1][j+1]
                else:
                    dp[i][j] = 0
        
        if dp != lcp:
            return ""
        
        return s