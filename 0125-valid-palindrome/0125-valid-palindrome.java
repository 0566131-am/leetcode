class Solution {
    public boolean isPalindrome(String s) {
        String ss=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        return ss.equals(new StringBuilder(ss).reverse().toString());
    }
}