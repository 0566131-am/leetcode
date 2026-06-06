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
    int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
      dia=0;
        getHeight(root);
        return dia;
    }
    private int getHeight(TreeNode node){
    if(node==null)
    return 0;
  int lh=getHeight(node.left);
  int rh=getHeight(node.right);
  int cd=lh+rh;
  dia=Math.max(dia,cd);
  return Math.max(lh,rh)+1;
    
    }
}