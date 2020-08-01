/**
 * Problem 106: Construct Binary Tree from Inorder and Postorder Traversal
 * Prompt: Given inorder and postorder traversal of a tree, 
 * construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 * Date: 07/27/2020
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        return buildTHelper(inorder, postorder, 0, 0, inorder.length - 1);
        
    }
    private TreeNode buildTHelper(int[] inorder, int[] postorder, int instart, int poststart, int inend)
    {
        int postend = inend - instart + poststart;
        if (inend < instart)
            return null;
        int val = postorder[postend];
        TreeNode cur = new TreeNode(val);
        int i = instart;
        while (i < inorder.length && inorder[i] != val)
            i++;
        cur.left = buildTHelper(inorder, postorder, instart, poststart, i - 1);
        cur.right = buildTHelper(inorder, postorder, i + 1, poststart + i - instart, inend);
        return cur;
        
    }
}