/**
 * Problem 886: Possible Bipartition
 * Prompt: Given a set of N people (numbered 1, 2, ..., N), we 
 * would like to split everyone into two groups of any size.
 * Each person may dislike some other people, and they should 
 * not go into the same group. 
 * Formally, if dislikes[i] = [a, b], it means it is not allowed
 * to put the people numbered a and b into the same group.
 * Return true if and only if it is possible to split everyone
 * into two groups in this way.
 * Date: 05/28/2020
 */
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
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; ++i)
        {
            if (!visited[i])
            {
                boolean t = isBipartite(N, newGraph, i, visited);
                if (t == false)
                    return false;
            }
                
        }
        return true;
    }
    private boolean isBipartite(int N, int[][] g, int src, boolean[] visited)
    {
        int[] colorArr = new int[N];
        Arrays.fill(colorArr, -1);
        Queue<Integer> bfsQueue = new LinkedList<Integer>();
        colorArr[src] = 1;
        bfsQueue.add(src);
        while (!bfsQueue.isEmpty())
        {
            int u = bfsQueue.poll();
            visited[u] = true;
            for (int i = 0; i < N; ++i)
            {
                if (g[u][i] == 1)
                {
                    if (colorArr[i] == -1)
                    {
                        colorArr[i] = 1 - colorArr[u];
                        bfsQueue.add(i);
                    }
                    else if (colorArr[i] == colorArr[u])
                        return false;
                }
                
            }
        }
        return true;
    }
}

/**
 * Check if the graph is a bipartitie graph by properly coloring the
 * nodes with two colors. This solution uses BFS. 
 */