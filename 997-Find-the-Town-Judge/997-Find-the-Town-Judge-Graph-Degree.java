class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] ans = new int[N + 1];
        for (int i = 0; i < trust.length; ++i)
        {
            ans[trust[i][1]]++;
            ans[trust[i][0]]--;
        }
        for (int i = 1; i <= N; ++i)
        {
            if (ans[i] == N - 1)
                return i;
        }
        return -1;
    }
}

/**
 * Notes: This is a undirected graph. 
 * Let the ones who trust a person be degres in 
 * and the ones that this person trus be degrees out
 * then the final degree for the town judge should be 
 * n - 1. 
 */