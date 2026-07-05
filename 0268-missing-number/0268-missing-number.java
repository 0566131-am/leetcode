class Solution {
    public int missingNumber(int[] nums) {
        int f=0;
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        f=n*(n+1)/2;
        return f-sum;
    }
}