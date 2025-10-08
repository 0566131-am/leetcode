class Solution:
    def intToRoman(self, num: int) -> str:
        
        #Grreedy Approach - we subtract our num  with highest denominations and repeat till we get 0.
       
        #step 1: lay out (value,symbol) from highest to lowest.
        val_map = [
        (1000, 'M'), (900, 'CM'), (500, 'D'), (400, 'CD'),
        (100, 'C'), (90, 'XC'), (50, 'L'), (40, 'XL'),
        (10, 'X'), (9, 'IX'), (5, 'V'), (4, 'IV'), (1, 'I')]

        #step 2: append string and subtract the max 'value' from num 
        res = ""
        for value, symbol in val_map: # start with higest denom as per map
            while num >= value: #greedy  - subtract from the highest denomination as much as needed till the number becomes less
                res += symbol
                num -= value
        return res