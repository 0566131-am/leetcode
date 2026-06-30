class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        # Track the last seen index of 'a', 'b', and 'c'
        last_seen = {'a': -1, 'b': -1, 'c': -1}
        count = 0
        
        for right, char in enumerate(s):
            # Update the latest position of the current character
            last_seen[char] = right
            
            # If all three characters have been seen at least once
            if last_seen['a'] != -1 and last_seen['b'] != -1 and last_seen['c'] != -1:
                # The number of valid substrings ending at 'right' is 
                # equal to 1 + the minimum index among the three characters
                count += min(last_seen['a'], last_seen['b'], last_seen['c']) + 1
                
        return count