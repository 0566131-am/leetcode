class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        less=[]
        more=[]
        p=[]
        for i in nums:
            if i<pivot:
                 less.append(i)
            elif i>pivot:
                more.append(i)
            else:
                p.append(i)
        return less+p+more
        