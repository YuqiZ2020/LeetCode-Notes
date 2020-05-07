/**
 * Problem 993: Cousins in Binary Tree
 * Prompt: In a binary tree, the root node is at depth 0, and children 
 * of each depth k node are at depth k+1.Two nodes of a binary tree are
 * cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, 
 * and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x 
 * and y are cousins.
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
    bool isCousins(TreeNode* root, int x, int y) {
        if (countDepth(root, x) == countDepth(root, y))
        {
            if (searchPair(root, x, y))
                return false;
            else
                return true;
        }
        return false;
    }
    int countDepth(TreeNode* root, int x)
    {
        if (root == nullptr)
            return -300;
        if (root->val == x)
            return 0;
        return (max(countDepth(root->left, x) + 1, countDepth(root->right, x) + 1));
    }
    bool searchPair(TreeNode* root, int x, int y)
    {
        if (root->left && root->right)
        {
            if ((root->left->val == x && root->right->val == y) ||
                (root->left->val == y && root->right->val == x))
                return true;
            else
                return (searchPair(root->left, x, y) || searchPair(root->right, x, y));
        }
        if (root->left)
            return searchPair(root->left, x, y);
        else if (root->right)
            return searchPair(root->right, x, y);
        return false;
    }
};

/**
 * Notes: First search through the tree and record the depth of each node. 
 * This is a recursive search: 
 *      Base case: when the searched root is nullptr, return -300 (smaller
 *      than the biggest node number 100); When the value is the same as 
 *      what we want, return 0;
 *      Otherwise return the max of left search result + 1 vs right research
 *      result + 1;
 * Then if the two nodes have same depth we need to make sure they don't
 * come from the same parents;
 * Search pair is a recursive search: 
 *      Base case: when either the left or right is nullptr, 
 *      search for the remaining side; when both are nullptr, return false;
 *      Otherwise return the search result of left || search result of right
 * */