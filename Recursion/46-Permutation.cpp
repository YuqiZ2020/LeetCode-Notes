/**
 * Problem 46: Permutation
 * Prompt: Given a collection of distinct integers, return all possible permutations.
 * */
class Solution {
public:
    void recPermu(vector<int>& nums, int begin, vector<vector<int>>& ans)
    {
        if (begin == nums.size())
            ans.push_back(nums);
        for (int i = begin; i < nums.size(); ++i)
        {
            swap(nums[begin], nums[i]);
            recPermu(nums, begin + 1, ans);
            swap(nums[begin], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        recPermu(nums, 0, ans);
        return ans;
    }
};

/**
 * Notes: This is a recursion. For each segment of the array, 
 * its permutation is a1 & permu(rest) + a2 & permu(rest) + ...
 * + an & permu(rest)
 * So we recursively find the permutation of each segments and combine
 * them. The base case is when there is no number left to permute
 * and we push back one instance of answer. 
 * */