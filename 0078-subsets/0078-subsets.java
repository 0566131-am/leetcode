import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base case: if we've made a choice for all elements, add the copy of current subset
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Include nums[index]
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);

        // Choice 2: Exclude nums[index] (Backtrack)
        current.remove(current.size() - 1);
        backtrack(index + 1, nums, current, result);
    }
}