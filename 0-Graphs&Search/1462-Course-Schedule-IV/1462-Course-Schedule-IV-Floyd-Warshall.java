class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) 
    {
        boolean[][] connected = new boolean[n][n];
        for (int i = 0; i < prerequisites.length; ++i)
            connected[prerequisites[i][0]][prerequisites[i][1]] = true;
        for (int k = 0; k < n; ++k)
        {
            for (int i = 0; i < n; ++i)
            {
                for (int j = 0; j < n; ++j)
                    connected[i][j] = connected[i][j] || (connected[i][k] && connected[k][j]);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; ++i)
            ans.add(connected[queries[i][0]][queries[i][1]]);
        return ans;
    }
}

/**
 * Use this Floyd-Warshall algorithm for minimum spanning tree
 * for finding the connections between nodes in a directed graph. 
 * The sequence of k, i, j matters because of the dp previous condition. 
 * Need to find the optimal path between i and j with 0 - k-1
 * intermediate nodes but also need to find the optimal path between
 * i and k and k to j with intermediate nodes 0 - k-1. So the outer
 * most loop must be k to consider each k step by step. 
 */