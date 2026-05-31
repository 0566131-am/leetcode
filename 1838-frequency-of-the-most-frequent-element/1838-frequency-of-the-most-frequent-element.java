class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        long currentsum=0;
        for(int right=0;right<nums.length;right++){
            currentsum=currentsum+nums[right];
            if((long)nums[right]*(right-left+1)-currentsum>k){
                currentsum=currentsum-nums[left];
                left++;
            }
        }
        return nums.length-left;
        
    }
}