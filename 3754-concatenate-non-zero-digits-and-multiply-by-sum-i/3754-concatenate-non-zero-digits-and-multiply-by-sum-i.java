class Solution {
    public long sumAndMultiply(int n) {
        long reversedX = 0;
        long sum = 0;
        
        // Step 1: Extract non-zero digits (this reverses their original order)
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                reversedX = reversedX * 10 + digit;
                sum += digit;
            }
            n /= 10;
        }
        
        // Step 2: Reverse it back to get the original order for x
        long x = 0;
        long temp = reversedX;
        while (temp > 0) {
            x = x * 10 + (temp % 10);
            temp /= 10;
        }
        
        // Step 3: Return the product
        return x * sum;
    }
}