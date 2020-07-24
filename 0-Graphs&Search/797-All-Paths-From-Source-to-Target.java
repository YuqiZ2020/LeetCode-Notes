/**
 * Problem 797: All Paths From Source to Target
 * Prompt: Given a directed, acyclic graph of N nodes.  Find all 
 * possible paths from node 0 to node N-1, and return them in 
 * any order.
 * The graph is given as follows:  the nodes are 
 * 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes 
 * j for which the edge (i, j) exists.
 * Date: 07/24/2020
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(graph, 0, answer, new ArrayList<>());
        return answer;
    }
    public void dfs(int[][] g, int start, List<List<Integer>> ans, List<Integer> cur)
    {
        cur.add(start);
        if (start == g.length - 1)
        {
            ans.add(new ArrayList<Integer>(cur)); // Add a new object
            cur.remove(cur.size() - 1);
            return;
        }
        for (int i: g[start])
            dfs(g, i, ans, cur);
        cur.remove(cur.size() - 1);
    }
}
/**
 * Notes: We don't need to record whether we have visited a graph
 * because it is acyclic. We just need to keep track of our path
 * in an array list and add a new object of it each time (other
 * wise it is pass by referece). Then we traverse using DFS. 
 */