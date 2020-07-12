/**
 * Problem 78: Subsets
 * Prompt: Given a set of distinct integers, nums, 
 * return all possible subsets (the power set).
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        ans.add(empty);
        for (int k = 0; k < len; ++k)
        {
            int t = ans.size();
            for (int i = 0; i < t; ++i)
            {
                List<Integer> newList = new ArrayList<>();
                for (int j = 0; j < ans.get(i).size(); ++j)
                {
                    newList.add(ans.get(i).get(j));
                }
                newList.add(nums[k]);
                ans.add(newList);
            }
        }
        return ans;
    }
}

/**
 * Notes: Given any element, we can either choose to add it
 * or not to add it. That's why there are 2^n different subsets. 
 * Therefore for each iteration, we look at all the current subsets, 
 * we can either leave them unchanged (not add), or create a 
 * duplicate of it and add the new element. So we would generate all
 * the possible solutions in the end. 
 */