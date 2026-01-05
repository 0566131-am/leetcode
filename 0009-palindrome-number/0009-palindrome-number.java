class Solution {
    public boolean isPalindrome(int n) {
        if(n<0)
        return false;
     int rev=0;
     int temp=n;
     while(temp!=0){
        int digit=temp%10;
        temp=temp/10;
        rev=rev*10+digit;
     }
     return(rev==n);
        
    }
}