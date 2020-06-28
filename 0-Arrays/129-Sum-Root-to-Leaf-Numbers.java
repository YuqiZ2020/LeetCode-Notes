/**
 * Problem 129: Sum Root to Leaf Numbers
 * Prompt: Given a binary tree containing digits from 0-9 only, 
 * each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Date: 06/26/2020
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
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        int[] ans = new int[1];
        dfs(root, 0, ans);
        return ans[0];
    }
    private void dfs(TreeNode root, int count, int[] ans)
    {
        count = count * 10 + root.val;
        if (root.left == null && root.right == null)
        {
            ans[0] += count;
            return;
        }
        if (root.left != null)
            dfs(root.left, count, ans);
        if (root.right != null)
            dfs(root.right, count, ans);
    }
}

/**
 * Notes: Use DFS to go through the tree till each end. 
 * The base case is when the node doesn't have left or right child. I didn't
 * use null as the base case is because this way each value would be computed
 * twice (through left and right, both are null). Then for each condition, 
 * count would be equal to count * 10 + current value. Then we search left
 * and then search right if they exists. 
 */