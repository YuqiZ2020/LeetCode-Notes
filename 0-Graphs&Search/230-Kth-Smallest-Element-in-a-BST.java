/**
 * Problem 230: Kth Smallest Element in a BST
 * Prompt: Given a binary search tree, write a 
 * function kthSmallest to find the kth smallest 
 * element in it.
 * Date: 05/20/2020
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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        dfs(root, k, 0, ans);
        return ans[0];
    }
    public int dfs(TreeNode root, int k, int prev, int ans[])
    {
        if (root == null)
            return t;      
        int cur = dfs(root.left, k, prev, ans) + 1;
        if (k == cur)
            ans[0] = root.val;
        return dfs(root.right, k, cur, ans);
    }
}

/**
 * Notes: Use a deepth first search to search the tree and count
 * the corresponding rank of each node. Search the left tree by 
 * passing in a previous counting result. After counting, compare
 * that value with k and see if it is the target. Search the right 
 * tree by passing the current point's count and return that value
 * as the whole count for the full subtree. 
 */