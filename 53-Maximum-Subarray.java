/**
 * Problem 53: Maximum Subarray
 * Prompt: Given a non-negative integer num represented as a string, 
 * remove k digits from the number so that the new number is 
 * the smallest possible.
 * Date: 05/16/2020
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; ++i)
        {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

/**
 * Notes: dp[i] is the max subarray sum from nums[0] to nums[i]. 
 * The current dp[i] will either be just nums[i] or nums[i] + dp[i - 1] 
 * (which is the subarray from before plus the current number)
 * The value max store the max value of the different dp[i], because
 * you need to keep track of the previous max sub arrays that don't
 * contain the current nums[i]. 
 */