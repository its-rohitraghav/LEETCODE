/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>>ans;
        queue<TreeNode*>q;
        if(root == NULL) return ans;
        q.push(root);
        bool LeToRe = true;
        while(!q.empty()){
            int s=q.size();
            vector<int>le;
            for(int i=0;i<s;i++){
                TreeNode* t=q.front();
                q.pop();
                le.push_back(t->val);
                if(t->left){
                    q.push(t->left);
                }
                if(t->right){
                    q.push(t->right);
                }
            }
            if(!LeToRe){
                reverse(le.begin(),le.end());
            }
            ans.push_back(le);
            LeToRe= !LeToRe;
        }
        return ans;
    }
};