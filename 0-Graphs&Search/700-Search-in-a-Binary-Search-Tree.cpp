/**
 * Problem 700: Search in a Binary Search Tree
 * Prompt: Given the root node of a binary search tree (BST) and a value. 
 * You need to find the node in the BST that the node's value equals
 * the given value. Return the subtree rooted with that node. 
 * If such node doesn't exist, you should return NULL.
 * Date: 06/15/2020
 * */

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
    TreeNode* searchBST(TreeNode* root, int val) {
        if (root == nullptr)
            return nullptr;
        int curVal = root->val;
        if (curVal == val)
            return root;
        if (val > curVal)
            return searchBST(root->right, val);
        return searchBST(root->left, val);
    }
};

/**
 * Notes: If root is nullptr means that we can't find it, so return
 * nullptr. If the current value is the one we want, just return the 
 * root. Otherwise compare the value with the root value. If bigger, 
 * search right child, if smaller, search left child. 
 * */