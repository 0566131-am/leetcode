class Solution {
    public int minOperations(String s) {
        int flip0=0;
        int flip1=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(i%2==0){
                if(c!='0')
                flip0++;
                if(c!='1')
                flip1++;
            }
            else{
            if(c!='1')
            flip0++;
            if(c!='0')
            flip1++;
        }
        
    }
    return Math.min(flip0,flip1);
        
    }
}