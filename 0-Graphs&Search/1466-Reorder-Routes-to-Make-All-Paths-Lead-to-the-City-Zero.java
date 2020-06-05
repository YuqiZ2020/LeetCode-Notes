/**
 * Problem 1466: Reorder Routes to Make All Paths Lead to the City Zero
 * Prompt: There are n cities numbered from 0 to n-1 and n-1 
 * roads such that there is only one way to travel between two 
 * different cities (this network form a tree). 
 * Last year, The ministry of transport decided to orient the 
 * roads in one direction because they are too narrow.
 * Roads are represented by connections where 
 * connections[i] = [a, b] represents a road from city a to b.
 * This year, there will be a big event in the capital (city 0),
 * and many people want to travel to this city.
 * Your task consists of reorienting some roads such that each
 * city can visit the city 0. Return the minimum number of 
 * edges changed.
 * It's guaranteed that each city can reach the city 0 after
 * reorder.
 * Date: 06/03/2020
 */
class Solution {
    public int minReorder(int n, int[][] connections) 
    {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adjList[i] = new ArrayList<Integer>();
        for (int i = 0; i < connections.length; ++i)
        {
            adjList[connections[i][1]].add(connections[i][0]);
            adjList[connections[i][0]].add(-connections[i][1]);
        }
        boolean[] visited = new boolean[n];
        int[] ans = new int[1];
        dfs(0, adjList, visited, ans);
        return ans[0];
    }
    
    public void dfs(int src, List<Integer>[] adjList, boolean[] visited, int[] count)
    {
        visited[src] = true;
        for (int i : adjList[src])
        {
            if (i >= 0)
            {
                if (!visited[i])
                    dfs(i, adjList, visited, count);
            }
            else if (!visited[-i])
            {
                count[0]++;
                dfs(-i, adjList, visited, count);
            }
        }
        return;
    }
}

/**
 * Notes: Save two directions of one path using positive and negative
 * numbers. Negative number represent the reversed path. 
 * Use dfs to visit the nodes starting from node zero. Since we know
 * that there will be only one path between one node and the other
 * node, then if we encouter a negative path we have to reverse it. 
 * So it is just to count the path that is directed away from node 0. 
 * Then if we encounter a negative path, we add one to our answer
 * and then continue the search. 
 */