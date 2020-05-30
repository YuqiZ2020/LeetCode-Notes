class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] newGraph = new int[N][N];
        for (int i = 0; i < dislikes.length; ++i)
        {
            int a = dislikes[i][0] - 1;
            int b = dislikes[i][1] - 1;
            newGraph[a][b] = 1;
            newGraph[b][a] = 1;
        }
        int[] colorArr = new int[N];
        for (int i = 0; i < N; ++i)
        {
            if (colorArr[i] == 0)
            {
                if (!dfs(newGraph, i, colorArr, 1))
                    return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] g, int src, int[] colorArr, int col)
    {
        colorArr[src] = col;
        for (int i = 0; i < g.length; ++i)
        {
            if (g[src][i] == 1)
            {
                if (colorArr[i] == col)
                    return false;
                else if (colorArr[i] == 0 && !dfs(g, i, colorArr, -col))
                    return false;
            }
        }
        return true;
    }
}

/**
 * Same for checking bipartite graph but uses DFS. 
 * Uses recursion for DFS to iterate through the graph. 
 */