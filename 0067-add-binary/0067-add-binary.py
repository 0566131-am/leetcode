class Solution:
    def addBinary(self, a: str, b: str) -> str:
        num1=int(a,2)
        num2=int(b,2)
        sum_bin=num1+num2;
        bin_sum=bin(sum_bin)[2:]
        return bin_sum
        