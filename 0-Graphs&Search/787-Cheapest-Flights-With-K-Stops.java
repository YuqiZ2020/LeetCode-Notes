class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Pair<Integer, Integer>>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < flights.length; ++i)
            adjList[flights[i][0]].add(new Pair(flights[i][1], flights[i][2]));
        int[] answer = new int[1];
        answer[0] = 10000000;
        DFS(n, adjList, src, dst, K, 0, answer);
        if (answer[0] == 10000000)
            return -1;
        return answer[0];
    }
    
    private void DFS(int n, List<Pair<Integer, Integer>>[] adjList, int src, 
                     int dst, int K, int cost, int[] ans)
    {
        if (src == dst)
        {
            ans[0] = cost;
            return;
        }
        if (K < 0)
            return;
        for (Pair p: adjList[src])
        {
            int newNode = (int) p.getKey();
            int newCost = cost + (int) p.getValue();
            if (newCost > ans[0])
                continue;
            DFS(n, adjList, newNode, dst, K - 1, newCost, ans);
        }
    }
}

/**
 * Notes: Need to prune to aviod TLE. This time we need to revisit
 * points because they might form a cheaper path given that the visitor
 * is from another node. However, pruning is essential to aviod unwanted 
 * visiting and to avoid TLE. 
 */