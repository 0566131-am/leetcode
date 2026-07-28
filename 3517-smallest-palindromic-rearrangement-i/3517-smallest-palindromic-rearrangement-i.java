class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;
        
        // Extract and sort the first half
        char[] half = s.substring(0, halfLen).toCharArray();
        Arrays.sort(half);
        
        String sortedHalf = new String(half);
        String reversedHalf = new StringBuilder(sortedHalf).reverse().toString();
        
        // Handle odd length middle character
        if (n % 2 == 1) {
            char mid = s.charAt(halfLen);
            return sortedHalf + mid + reversedHalf;
        }
        
        return sortedHalf + reversedHalf;
    }
}