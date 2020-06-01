/**
 * Problem 226: Invert Binary Tree
 * Prompt: Invert a binary tree.
 */

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invertTree(root.left);
        root.right= invertTree(root.right);
        return root;
    }
}

/**
 * Notes: This is a recursive function. For any given node, 
 * if it is null, then just return null. Otherwise
 * swap the pointers for the left node and the right node, 
 * Then call the function for the left node and the right
 * node respectively to perform operation on the subtrees. 
 */