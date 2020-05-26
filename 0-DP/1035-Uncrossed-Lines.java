/**
 * Problem 1035: Uncrossed Lines
 * Prompt: We write the integers of A and B (in the 
 * order they are given) on two separate horizontal lines.
 * Now, we may draw connecting lines: a straight line 
 * connecting two numbers A[i] and B[j] such that:
 *      A[i] == B[j];
 *      The line we draw does not intersect any other 
 *          connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at 
 * the endpoints: each number can only belong to one 
 * connecting line.
 * Return the maximum number of connecting 
 * lines we can draw in this way.
 * Date: 05/25/2020
 */

class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[B.length][A.length];
        if (A[0] == B[0])
            dp[0][0] = 1;
        for (int i = 1; i < A.length; ++i)
        {
            if (B[0] == A[i] || dp[0][i - 1] == 1)
                dp[0][i] = 1;
        }
        for (int i = 1; i < B.length; ++i)
        {
            if (B[i] == A[0] || dp[i - 1][0] == 1)
                dp[i][0] = 1;
        }  
        for (int i = 1; i < B.length; ++i)
        {
            for (int j = 1; j < A.length; ++j)
            {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (B[i] == A[j])
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[B.length - 1][A.length - 1];
    }
}