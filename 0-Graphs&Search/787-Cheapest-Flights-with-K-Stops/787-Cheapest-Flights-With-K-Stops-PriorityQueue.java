class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Pair<Integer, Integer>>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < flights.length; ++i)
            adjList[flights[i][0]].add(new Pair(flights[i][1], flights[i][2]));
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        q.offer(new int[]{0, src, K + 1});
        while (!q.isEmpty())
        {
            int[] temp = q.poll();     
            int dist = temp[0];
            int node = temp[1];
            int steps = temp[2];
            if (node == dst)
                return dist;
            if (steps > 0)
            {
                for (Pair<Integer, Integer> i : adjList[node])
                {
                    q.add(new int[]{dist + i.getValue(), i.getKey(), steps - 1});
                }
            }
            
        }
        return -1;
    }
    
    
}

/**
 * Notes: This is a variation of Dijkstra's Algorithm. Since we are constrianed
 * with the number of steps, we can't let go those paths with distance longer
 * because they might have too many steps. Therefore we just store everything 
 * into the priority queue using the distance as a priority. Then we can visit
 * all those points and update their distance from the original point. Then we
 * would be gaurenteed to find the shortest path that satisfy the prompt. 
 */