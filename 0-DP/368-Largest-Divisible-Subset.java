/**
 * Problem 368: Largest Divisible Subset
 * Prompt: Given a set of distinct positive integers, find the 
 * largest subset such that every pair (Si, Sj) of elements 
 * in this subset satisfies:
 * Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 * Date: 06/13/2020
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length; 
        List<Integer> ans = new ArrayList<>();
        if (len < 1)
            return ans;
        Arrays.sort(nums);
        int[] dp = new int[len];
        int[] prev = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        for (int i = 0; i < len; ++i)
        {
            for (int j = i - 1; j >= 0; --j)
            {
                if (nums[i] % nums[j] == 0)
                {
                    if (dp[j] + 1 > dp[i])
                        prev[i] = j;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                     
            }
        }
        int maxIdx = 0;
        for (int i = 0; i < len; ++i)
        {
            if (dp[i] > dp[maxIdx])
                maxIdx = i;
        }
        int cur = maxIdx;
        while (cur != -1)
        {
            ans.add(nums[cur]);
            cur = prev[cur];
        }
        return ans;
    }
}

/**
 * Notes: DP
 */