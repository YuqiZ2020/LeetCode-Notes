/**
 * Problem: 70. Climbing Stairs
 * Prompt: You are climbing a stair case. It takes n steps to 
 * reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many 
 * distinct ways can you climb to the top?
 * Date: 07/31/2020
 */
class Solution {
    public int climbStairs(int n) {
        int d1 = 1;
        int d2 = 2;
        for (int i = 3; i <= n; i += 2)
        {
            d1 = d1 + d2;
            d2 = d1 + d2;
        }
        if (n % 2 == 0)
            return d2;
        return d1;
    }
}

/**
 * Notes: Dynamic programming can solve this problem. 
 * Initial condition is d1 = 1 and d2 = 2. Then any condition 
 * adter this would have dp[i] = dp[i - 1] + dp[i - 2] because
 * we can either take a step from i - 1 or take two steps
 * from i - 2. Then we can reduce the memory by allowing only
 * two variables to store two conditions and decide which 
 * condition to output by parity in the end. 
 */