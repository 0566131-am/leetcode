import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int c = 1; // current sequence length
        int m = 1; // maximum sequence length

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                continue; // skip duplicate
            }

            if (nums[i] == nums[i - 1] + 1) {
                c++;
            } else {
                c = 1;
            }

            if (c > m) {
                m = c;
            }
        }

        return m;
    }
}