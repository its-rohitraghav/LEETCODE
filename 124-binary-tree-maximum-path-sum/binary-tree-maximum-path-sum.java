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
    int maxi=Integer.MIN_VALUE;
    public int h(TreeNode root){
        if(root == null) return 0;
        int lh= Math.max(0,h(root.left));
        int rh= Math.max(0,h(root.right));
        maxi= Math.max(maxi,root.val+lh+rh);
        return root.val + Math.max(lh,rh);
    }
    public int maxPathSum(TreeNode root) {
        h(root);
        return maxi;
    }
}