import java.util.Stack;
class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<num.length();i++){
            char currentDigit=num.charAt(i);
            while(!stack.isEmpty()&&k>0&&stack.peek()>currentDigit){
                stack.pop();
                k--;
            }
            stack.push(currentDigit);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();


        
    }
}