/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
      List<Long> levelSums = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
          while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long currentLevelSum = 0;
           for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currentLevelSum += curr.val;
                
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            
            levelSums.add(currentLevelSum);
        } 
        if (levelSums.size() < k) {
            return -1;
        }
        Collections.sort(levelSums);
        return levelSums.get(levelSums.size() - k);
        
    }
}