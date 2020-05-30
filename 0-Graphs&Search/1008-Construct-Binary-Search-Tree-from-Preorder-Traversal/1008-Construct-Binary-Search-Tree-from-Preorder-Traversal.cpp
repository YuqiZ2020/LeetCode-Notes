class Solution {
public:
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        int i = 0;
        return bstPreorder(preorder, i, INT_MAX);
    }

    TreeNode* bstPreorder(vector<int>& A, int& i, int bound) {
        if (i == A.size() || A[i] > bound) 
            return nullptr;
        TreeNode* root = new TreeNode(A[i++]);
        root->left = bstPreorder(A, i, root->val);
        root->right = bstPreorder(A, i, bound);
        return root;
    }
};