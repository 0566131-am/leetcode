import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] candidates, int target, int currentSum, List<Integer> current, List<List<Integer>> result) {
        if (currentSum > target) {
            return;
        }
        
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
  
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]); 
            
           
            backtrack(i, candidates, target, currentSum + candidates[i], current, result);
            
            current.remove(current.size() - 1); 
        }
    }
}