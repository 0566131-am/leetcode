import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        
        // Step 1: group indices by value
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        // Step 2: process each group
        for (List<Integer> list : map.values()) {
            int size = list.size();
            
            // prefix sum
            long prefixSum = 0;
            
            // Left to right
            for (int i = 0; i < size; i++) {
                int idx = list.get(i);
                res[idx] += (long) idx * i - prefixSum;
                prefixSum += idx;
            }
            
            // reset prefix sum
            prefixSum = 0;
            
            // Right to left
            for (int i = size - 1; i >= 0; i--) {
                int idx = list.get(i);
                res[idx] += prefixSum - (long) idx * (size - 1 - i);
                prefixSum += idx;
            }
        }
        
        return res;
    }
}