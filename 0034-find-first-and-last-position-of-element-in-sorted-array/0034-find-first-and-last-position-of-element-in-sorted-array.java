class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        
        return result;
    }
    public int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                index=mid;
                right=mid-1;

            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
           
        }
         return index;

        }

        public int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                index=mid;
                left=mid+1;

            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
            
        }
        
        return index;

        
    }
}
