class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        List<Integer> sqs = new ArrayList<>();
        for (int i = 2; i <= n; ++i)
        {
            if ((int) Math.sqrt(i) * (int) Math.sqrt(i) == i)
            {
                dp[i] = 1;
                sqs.add(i);
            }
            else
            {
                int res = i;
                for (int j = sqs.size() - 1; j >= 0; --j)
                    res = Math.min(res, dp[i - sqs.get(j)] + 1);
                dp[i] = res;
            }
        }
        return dp[n];
    }
}

/**
 * Notes: Use dynamic programming to save the best result for each number
 * then go through the possible choices (select a perfect square to subtract
 * from and then see the rest of the number to find the optimal solution
 * for each i. 
 */