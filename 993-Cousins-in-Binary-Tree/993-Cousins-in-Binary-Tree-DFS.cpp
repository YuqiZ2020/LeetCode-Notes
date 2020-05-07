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
    bool isCousins(TreeNode* root, int x, int y) {
        pair<int, int> dep_par_x;
        pair<int, int> dep_par_y;
        dfs(root, x, y, 0, 0, dep_par_x, dep_par_y);
        return (dep_par_x.first == dep_par_y.first && 
                dep_par_x.second != dep_par_y.second);
    }
    void dfs(TreeNode* root, int x, int y, int depth, int parent, pair<int, int>& px, pair<int, int>& py)
    {
        if (root == nullptr)
            return;
        if (root->val == x)
        {
            px.first = depth;
            px.second = parent;
        }
        if (root->val == y)
        {
            py.first = depth;
            py.second = parent;
        }
        dfs(root->left, x, y, depth + 1, root->val, px, py);
        dfs(root->right, x, y, depth + 1, root->val, px, py); 
    }
    
};

/**
 * Uses deep first search to search through the tree
 * Once x or y is found, the depth and parent info pair is stored. 
 * Otherwise search left side and then search right side. 
 * Return the function when reaches nullptr. 
 * Finally compare results
 * */