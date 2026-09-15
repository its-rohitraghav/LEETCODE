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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        boolean LeToRe=true;
        while(!q.isEmpty()){
            int s= q.size();
            List<Integer>le=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode t= q.poll();
                le.add(t.val);
                if(t.left != null){
                    q.add(t.left);
                }
                if(t.right !=null){
                    q.add(t.right);
                }
            }
            if(!LeToRe){
                Collections.reverse(le);
            }
            ans.add(le);
            LeToRe= !LeToRe;
        }
        return ans;
    }
}