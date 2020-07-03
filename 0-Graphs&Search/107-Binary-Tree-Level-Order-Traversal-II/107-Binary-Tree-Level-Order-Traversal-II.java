/**
 * Problem 107: Binary Tree Level Order Traversal II
 * Prompt: Given a binary tree, return the bottom-up level order traversal
 * of its nodes' values. (ie, from left to right, level by level from 
 * leaf to root).
 * Date: 07/02/2020
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>(); 
        q.add(new Pair(root, 0));
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty())
        {
            Pair<TreeNode, Integer> t = q.remove();
            if (t.getKey() != null)
            {
                int oldH = t.getValue();
                q.add(new Pair(t.getKey().left, oldH + 1));
                q.add(new Pair(t.getKey().right, oldH + 1));
                if (ans.size() <= oldH)
                {
                    List<Integer> newLevel = new ArrayList<>();
                    newLevel.add(t.getKey().val);
                    ans.add(0, newLevel);
                }
                else
                    ans.get(ans.size() - oldH - 1).add(t.getKey().val);
            }
        }
        return ans;
    }
}

/**
 * Notes: Use BFS to traverse the binary tree. Use a queue to store
 * the node that we encountered. When pulling each node out, we should 
 * add its childern to the queue. Then we should put this node at the 
 * correct place based on the recorded height. 
 */