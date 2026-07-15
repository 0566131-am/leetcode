class Solution {
    public boolean judgeSquareSum(int c) {
        long left=0;
        long right=(long)Math.sqrt(c);
        while(left<=right){
            long d=left*left+right*right;
            if(d==c){
                return true;
            }
            else if(d>c)
            {
                right--;
                
            }
            else{
                left++;
            }
        }
        return false;
    }
        
    }