class Solution {
    public int singleNumber(int[] nums) {
        int numm=0;
        for(int i=0;i<nums.length;i++){
             numm=numm^nums[i]; 
        }
        return numm;

        
    }
}