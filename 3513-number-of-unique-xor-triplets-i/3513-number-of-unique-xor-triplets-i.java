class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // Base cases for n <= 2
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Find the smallest power of 2 strictly greater than n
        int powerOfTwo = 1;
        while (powerOfTwo <= n) {
            powerOfTwo <<= 1;
        }

        return powerOfTwo;
    }
}