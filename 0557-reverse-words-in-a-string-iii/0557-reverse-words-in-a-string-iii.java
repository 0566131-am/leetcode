class Solution {
    public String reverseWords(String s) {
       String[]words=s.split(" ");
       StringBuilder sb=new StringBuilder();
       for(String word:words) {
        sb.append(new StringBuilder(word).reverse()).append(" ");
       }
       return sb.toString().trim();
    }
}