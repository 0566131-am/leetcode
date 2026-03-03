class Solution {
    public char findKthBit(int n, int k) {
        
        // Base case
        if (n == 1) {
            return '0';
        }

        int mid = 1 << (n - 1);  // 2^(n-1)

        // If k is middle
        if (k == mid) {
            return '1';
        }

        // If k is in left half
        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        // If k is in right half
        char ch = findKthBit(n - 1, 2 * mid - k);
        
        // Invert the result
        return ch == '0' ? '1' : '0';
    }
}