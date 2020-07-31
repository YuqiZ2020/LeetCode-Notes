/**
 * Problem 1530: Number of Good Leaf Nodes Pairs
 * Prompt: Given the root of a binary tree and an integer distance. 
 * A pair of two different leaf nodes of a binary tree is said to be 
 * good if the length of the shortest path between them is less 
 * than or equal to distance.
 * Return the number of good leaf node pairs in the tree.
 * Date: 07/25/2020
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
    public int countPairs(TreeNode root, int distance) {
        int[] answer = new int[1];
        dfs(root, answer, distance);
        return answer[0];
    }
    private List<Integer> dfs(TreeNode root, int[] ans, int req)
    {
        if (root.left == null && root.right == null)
            return new ArrayList<>(Arrays.asList(1));
        List<Integer> curLeft = new ArrayList<>();
        List<Integer> curRight = new ArrayList<>();
        if (root.left != null)
            curLeft = dfs(root.left, ans, req);
        if (root.right != null)
            curRight = dfs(root.right, ans, req);
        for (int i = 0; i < curLeft.size(); ++i)
        {
            for (int j = 0; j < curRight.size(); ++j)
            {
                if (curLeft.get(i) + curRight.get(j) <= req)
                    ans[0]++;
            }
        }
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < curLeft.size(); ++i)
            cur.add(curLeft.get(i) + 1);
        for (int j = 0; j < curRight.size(); ++j)
            cur.add(curRight.get(j) + 1);
        return new ArrayList<>(cur);
            
    }
}

/**
 * Notes: Use an arraylist to record the different distances towards
 * this current node and return this to upper callers. For each node
 * we use dfs to look at left and right and see all the different distances, 
 * and we add different pairs of distances to count the valid pairs for this
 * level. Then we do increment for all the distances from left and write, 
 * concatenate them and return them back to the caller. 
 * The base case is when this node is a leaf node and we just return an 
 * array list with one distance as 1. 
 */