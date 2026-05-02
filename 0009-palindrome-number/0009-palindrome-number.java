class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindromes (e.g., -121 != 121-)
        // 2. Numbers ending in 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            // Get the last digit and move it to reversedHalf
            reversedHalf = reversedHalf * 10 + x % 10;
            // Remove the last digit from x
            x /= 10;
        }

        // For even-length numbers (e.g., 1221), x will be 12 and reversedHalf will be 12.
        // For odd-length numbers (e.g., 121), x will be 1 and reversedHalf will be 12.
        // We get rid of the middle digit by reversedHalf / 10.
        return x == reversedHalf || x == reversedHalf / 10;
    }
}