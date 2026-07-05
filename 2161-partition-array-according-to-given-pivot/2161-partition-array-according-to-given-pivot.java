import java.util.stream.Stream;
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       List<Integer> less=new ArrayList<>();
       List<Integer> more=new ArrayList<>();
       List<Integer> p=new ArrayList<>();
       for(int i=0;i<nums.length;i++){
        if(nums[i]<pivot)
        less.add(nums[i]);
        else if (nums[i]>pivot)
        more.add(nums[i]);
        else
        p.add(nums[i]);
       }
       return Stream.of(less,p,more)
       .flatMap(List::stream)
       .mapToInt(Integer::intValue)
       .toArray();
    }
}