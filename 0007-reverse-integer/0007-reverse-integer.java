class Solution {
    public int reverse(int n) {
        long rev=0;
        int temp=n;
        while(temp!=0){
            int digit=temp%10;
            temp=temp/10;
            rev=rev*10+digit;
        }
        if(rev>Integer.MAX_VALUE||rev<Integer.MIN_VALUE){
            return 0;
        }
        return (int)rev;
        
    }
}