import math

class Solution:
    def minNumberOfSeconds(self, mountainHeight, workerTimes):
        def can(t):
            total = 0
            for w in workerTimes:
                x = int((-1 + math.sqrt(1 + 8*t/w)) // 2)
                total += x
                if total >= mountainHeight:
                    return True
            return False

        left, right = 1, 10**16

        while left < right:
            mid = (left + right) // 2
            if can(mid):
                right = mid
            else:
                left = mid + 1

        return left