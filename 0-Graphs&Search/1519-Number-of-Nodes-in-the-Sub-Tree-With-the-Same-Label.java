/**
 * Problem 1519: Number of Nodes in the Sub-Tree With the Same Label
 * Prompt: Given a tree (i.e. a connected, undirected graph that has 
 * no cycles) consisting of n nodes numbered from 0 to n - 1 and 
 * exactly n - 1 edges. The root of the tree is the node 0, and each 
 * node of the tree has a label which is a lower-case character given 
 * in the string labels (i.e. The node with the number i has the 
 * label labels[i]).
 * The edges array is given on the form edges[i] = [ai, bi], which 
 * means there is an edge between nodes ai and bi in the tree.
 * Return an array of size n where ans[i] is the number of nodes 
 * in the subtree of the ith node which have the same label as node i.
 * A subtree of a tree T is the tree consisting of a node in T and 
 * all of its descendant nodes.
 * Date: 07/18/2020
 */
class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; ++i)
        {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        int[][] lettersCount = new int[n][26];
        for (int i = 0; i < n; ++i)
            lettersCount[i][labels.charAt(i) - 'a'] = 1;
        dfs(0, adjList, lettersCount);
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i)
            ans[i] = lettersCount[i][labels.charAt(i) - 'a'];
        return ans;
    }
    public void dfs(int cur, List<Integer>[] adj, int[][] lCount)
    {
        for (int i: adj[cur])
        {
            adj[i].remove(adj[i].indexOf(cur));
            dfs(i, adj, lCount);
            for (int j = 0; j < 26; ++j)
                lCount[cur][j] += lCount[i][j];
        }
    }
}

/**
 * Notes: How to do counts for all nodes together in one traverse? 
 * Extra space can help us by storing counts of all 26 lower case 
 * letters (we might not need this information for this node in 
 * particular, but the ancestor nodes of this node might need this, 
 * so we are storing all information). I used an n * 26 matrix to 
 * store counts for each nodes.
 * Therefore, for each node we loop through all the adjacent nodes, 
 * perform DFS for that new node, and update the letter counts for 
 * all 26 letters for this current node based on the new node's 
 * feed back after the DFS.
 * Some details:
 * Since we are dealing with a undirected graph, we need to store 
 * two sides of an edge in the adjacency list.
 * I do deletion for the reverse route once we take one route to
 * avoid unwantedly going back. 
 * I store the initial labels information in the 26 * n matrix, 
 * so we don't have to pass in the label for DFS everytime. 
 * This saves a lot of time.
 */