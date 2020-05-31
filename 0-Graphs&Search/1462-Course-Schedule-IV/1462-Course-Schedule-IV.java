/**
 * Problem 1462: Course Schedule IV
 * Prompt: There are a total of n courses you have to take, 
 * labeled from 0 to n-1.
 * Some courses may have direct prerequisites, for example, 
 * to take course 0 you have first to take course 1, 
 * which is expressed as a pair: [1,0]
 * Given the total number of courses n, a list of direct 
 * prerequisite pairs and a list of queries pairs.
 * You should answer for each queries[i] whether the course 
 * queries[i][0] is a prerequisite of the course queries[i][1] or not.
 * Return a list of boolean, the answers to the given queries.
 * Please note that if course a is a prerequisite of course b and
 *  course b is a prerequisite of course c, then, course a is a 
 * prerequisite of course c.
 */
class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) 
    {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adjList[i] = new ArrayList<Integer>();
        for (int i = 0; i < prerequisites.length; ++i)
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        int len = queries.length;
        List<Boolean> ans = new ArrayList<Boolean>();
        Boolean[] t = new Boolean[1];
        Boolean[] visited = new Boolean[n];
        for (int i = 0; i < len; ++i)
        {
            t[0] = false;
            for (int j = 0; j < n; ++j)
                visited[j] = false;
            DFS(adjList, queries[i][1], queries[i][0], t, visited);
            ans.add(t[0]);
        }
        return ans;
    }
    public void DFS(List<Integer>[] g, int src, int target, Boolean[] t, Boolean[] visited)
    {
        visited[src] = true;
        for (int i : g[src])
        {
            if (i == target)
            {
                t[0] = true;
                return;
            }
            else if (visited[i] == false)
                DFS(g, i, target, t, visited);
        }
        return;
    }
}

/**
 * Notes: Use DFS to find certain nodes starting from one node
 * in a directed graph. Need to record whether the node has
 * been visited using another array. 
 * Once found, store the answer and return. 
 */