class Solution {
    public int findClosestNumber(int[] nums) {
        int c = nums[0];
        for (int i = 1; i < nums.length; i++) {
            
            if (Math.abs(nums[i]) < Math.abs(c)) {
                c = nums[i];
            } 
        
            else if (Math.abs(nums[i]) == Math.abs(c) && nums[i] > c) {
                c = nums[i];
            }
        }
        return c;  
    }
}