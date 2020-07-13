class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        boolean[] visited = new boolean[n + 1];
        dp[1] = true;
        visited[1] = true;
        dfs(dp, visited, n);
        return dp[n];
    }
    public boolean dfs(boolean[] dp, boolean[] visited, int num)
    {
        if (visited[num])
            return dp[num];
        visited[num] = true;
        int t = (int) Math.sqrt(num);
        if (t * t == num)
        {
            dp[num] = true;
            return true;
        }
        boolean ans = false;
        for (int i = 1; i < Math.sqrt(num); ++i)
        {
            boolean temp = dfs(dp, visited, num - i * i);
            if (temp)
                ans = ans || false;
            else 
                ans = ans || true;
        }
        dp[num] = ans;
        return ans;
    }
}