/**
 * Problem 437: Path Sum III
 * Prompt: You are given a binary tree in which each node 
 * contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a 
 * leaf, but it must go downwards (traveling only from parent 
 * nodes to child nodes).
 * Date: 08/08/2020
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
    int pathSum(TreeNode* root, int sum) {
        map<int, int> preSumFreq;
        preSumFreq[0] = 1;
        return dfs(root, 0, sum, preSumFreq);
    }
    int dfs(TreeNode* root, int curSum, int req, map<int, int>& preSum)
    {
        if (root == nullptr)
            return 0;
        curSum += root->val;
        int ans = preSum[curSum - req];
        preSum[curSum]++;
        ans += dfs(root->left, curSum, req, preSum) + dfs(root->right, curSum, req, preSum);
        preSum[curSum]--;
        return ans;
    }
};

/**
 * Notes: Use a map to store the occurance frequency of any prefix 
 * sums. We pass the current prefix sum from paraent node as a parameter, 
 * and we add the current value to this sum. Then in the map we find
 * the occurances of curSum - req to see how many satisfy the requirement. 
 * Then we do the search for left and right, and let them return the 
 * number of pairs that satisfy the requirement with them as root. 
 * Then we get rid of the current sum in the map because we are returning
 * back and we don't want children to interfere with the parents. 
 * Then we return the current level's answer. 
 */