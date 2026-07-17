import java.util.ArrayList;
import java.util.HashSet;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res=new ArrayList<>();
        HashSet<Integer> set =new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        for(int num:nums2){
            if(set.contains(num)){
                res.add(num);
                set.remove(num);
            }
        }
        int [] result=new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
}