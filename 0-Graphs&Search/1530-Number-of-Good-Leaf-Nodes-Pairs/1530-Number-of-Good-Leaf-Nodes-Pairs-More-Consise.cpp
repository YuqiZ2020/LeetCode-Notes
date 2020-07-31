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
    int countPairs(TreeNode* root, int distance) {
        int answer = 0;
        dfs(root, distance, answer);
        return answer;
    }
    int* dfs(TreeNode* root, int dist, int& ans)
    {
        int* cur = new int[11];
        memset(cur, 0, 44);
        if (root == nullptr)
            return cur;
        if (root->left == nullptr && root->right == nullptr)
        {
            cur[1]++;
            return cur;
        }
        int* l = dfs(root->left, dist, ans);
        int* r = dfs(root->right, dist, ans);
        for (int i = 1; i <= 10; ++i)
        {
            for (int j = 1; j <= 10; ++j)
            {
                if (i + j <= dist)
                    ans += l[i] * r[j];
            }
        }
        for (int i = 1; i <= 10; ++i)
        {
            cur[i] = l[i - 1] + r[i - 1]; 
        }
        return cur;
        
    }
};

/**
 * Notes: This is a more consise version. Since distance only goes up
 * to 10, we only care about these distances, any distance bigger
 * than this can be ignored, so we just set up arrays to store the counts
 * and we can do multiplications for pair of valid distance sums. 
 * */