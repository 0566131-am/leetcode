class Solution {
    public int findGCD(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int min=nums[0];
        for(int i=0;i<nums.length;i++)
{
    if(nums[i]<min){
        min=nums[i];
    }
}
return gcd(min,max);
    }
private int gcd (int a,int b){
 if(b==0){
    return a;
 }
 return gcd(b,a%b);
}
}