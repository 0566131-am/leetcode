class Solution {
    public boolean isBalanced(String num) {
        int es=0;
        int os=0;
        for(int i=0;i<num.length();i++){
            int dig=num.charAt(i)-'0';
            if(i%2==0){
                es+=dig;
            }else{
                os+=dig;
            }
        }
        return es==os;
        
    }
}