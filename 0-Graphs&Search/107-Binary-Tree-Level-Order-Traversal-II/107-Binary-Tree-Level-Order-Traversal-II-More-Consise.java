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
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; ++i)
            {
                TreeNode node = q.poll();
                temp.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(0, temp);
        }
        return ans;
    }
}
/**
 * Notes: Actually we don't have to store the height for each node. 
 * During BFS, since each time we would process all the children 
 * of the node on the same level, so we could pull all the nodes
 * on the same level out all at once and store them. 
 */