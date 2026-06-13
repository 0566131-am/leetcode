class Solution {
    public int maxScore(int[] nums) {
      Arrays.sort(nums);
        int score = 0;
        long prefixSum = 0; 
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixSum += nums[i];

            if (prefixSum > 0) {
                score++;
            } else {
                break;
            }
        }
        
        return score;  
        
        
    }
}