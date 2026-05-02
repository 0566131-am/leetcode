class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int num : nums) {
            if (num == 1) {
                // If we see a 1, increment the current streak
                currentCount++;
            } else {
                // If we see a 0, update maxCount and reset current streak
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        
        // Final check to handle cases where the array ends with 1s
        return Math.max(maxCount, currentCount);
    }
}