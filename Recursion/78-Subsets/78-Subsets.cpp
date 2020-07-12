class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) 
    {
        vector<vector<int>> ans;
        vector<int> temp;
        backtrack(nums, 0, temp, ans);
        return ans;
    }
    void backtrack(vector<int>& nums, int start, vector<int>& curr, vector<vector<int>>& ans)
    {
        ans.push_back(curr);
        for (int i = start; i < nums.size(); ++i)
        {
            curr.push_back(nums[i]);
            backtrack(nums, i + 1, curr, ans);
            curr.erase(curr.begin() + curr.size() - 1);
        }
    }
};

/**
 * Notes: Each time we meet a subset, we can either leave it as it is (just add
 * it to the solution set), or keep adding the rest of the elements to it. 
 * Each time we just add one element that we haven't met before, and then recursively
 * call the function again to let it decide the future elements. Then we need
 * to erase this element and restart the for loop. 
 * */