class Solution:
    def numberOfSteps(self, num):
        steps = 0
        while num:
            steps += 1
            if num & 1:        
                num -= 1
            else:              
                num >>= 1
        return steps
