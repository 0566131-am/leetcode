class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
            
        # 1. Define the dictionary mapping (your 'd1')
        d1 = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"
        }
        
        res = [] # Initialize your result list
        
        def backtracking(i, combinations):
            if i == len(digits):
                res.append("".join(combinations))
                return
            
            # 2. Get the correct string of letters for the current digit
            # Note: You need to index into digits using 'i' -> digits[i]
            for ch in d1[digits[i]]:
                combinations.append(ch)       # 1. Choose
                backtracking(i + 1, combinations) # 2. Explore next digit
                combinations.pop()             # 3. Unchoose (backtrack)
                
        # 3. Kick off the recursion
        backtracking(0, [])
        return res