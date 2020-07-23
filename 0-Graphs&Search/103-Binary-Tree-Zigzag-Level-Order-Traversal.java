/**
 * Problem 103: Binary Tree Zigzag Level Order Traversal
 * Prompt: Given a binary tree, return the zigzag level order traversal of its 
 * nodes' values. (ie, from left to right, then right to left for the next 
 * level and alternate between).
 * Date: 07/22/2020
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        boolean flag = true;
        while (!q.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; ++i)
            {
                TreeNode node = q.poll();
                if (flag)
                    temp.add(node.val);
                else
                    temp.add(0, node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            flag = !flag;
            ans.add(temp);
        }
        return ans;
    }
}

/**
 * Notes: This is basically the same as problem 107. Except
 * that we need to take turns to reverse the storing sequence. 
 * We can keep a flag to reverse the storing order, but not changing
 * the queue order (or it would be messed up). 
 */