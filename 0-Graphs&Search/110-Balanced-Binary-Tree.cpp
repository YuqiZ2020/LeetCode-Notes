/**
 * Problem 110: Balanced Binary Tree
 * Prompt: Given a binary tree, determine if it is 
 * height-balanced.
 * For this problem, a height-balanced binary tree is 
 * defined as:
 * a binary tree in which the left and right subtrees 
 * of every node differ in height by no more than 1.
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
    bool isBalanced(TreeNode* root) {
        if (treeDegree(root) == -1)
            return false;
        return true;
    }
    int treeDegree(TreeNode* root)
    {
        if (root == nullptr)
            return 0;
        int hl = treeDegree(root->left);
        int hr = treeDegree(root->right);
        if (hl == -1 || hr == -1)
            return -1;
        if (abs(hl - hr) > 1)
            return -1;
        return max(hl, hr) + 1;
    }
};

/**
 * Notes: Recursively determine the height of each sutree, 
 * and compare the left tree degree and right tree degree
 * if one of them said it is invalid (-1), then return (-1). 
 * Other wise see the difference of height to check if it
 * is valid. If valid, then return the max height of the children
 * plus 1 for the degree of this subtree. 
 * */