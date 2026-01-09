class Solution {
    public int rob(int[] nums) {
        int rob=0;
        int skip=0;
        for(int n:nums){
            int newrob=skip+n;
            skip=Math.max(skip,rob);
            rob=newrob;
        }
        return Math.max(rob,skip);
        
    }
}