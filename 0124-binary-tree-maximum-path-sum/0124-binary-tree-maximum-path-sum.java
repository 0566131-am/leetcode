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
    private int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE; 
        calculateGain(root);
        return maxSum;
    }
    private int calculateGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lg=Math.max(calculateGain(node.left),0);
        int rg=Math.max(calculateGain(node.right),0);
        int cps=node.val+lg+rg;
        maxSum=Math.max(maxSum,cps);
        return node.val+Math.max(lg,rg);

    }
}