class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair<Integer, Double>>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; ++i)
        {
            adjList[edges[i][0]].add(new Pair(edges[i][1], succProb[i]));
            adjList[edges[i][1]].add(new Pair(edges[i][0], succProb[i]));
        }   
        PriorityQueue<double[]> q = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[0],o1[0]);
            }
        });
        
        q.offer(new double[]{1, start});
        double[] probList = new double[n];
        Arrays.fill(probList, 0);
        probList[start] = 1;
        boolean[] visited = new boolean[n];
        while (!q.isEmpty())
        {
            double[] temp = q.poll();
            double prob = temp[0];
            int node = (int) temp[1];
            visited[node] = true;
            for (Pair<Integer, Double> i : adjList[node])
            {
                int curNode = (int) i.getKey();
                if (visited[curNode])
                    continue;
                double newProb = prob * i.getValue();
                if (probList[curNode] < newProb)
                {
                    probList[curNode] = newProb;
                    q.offer(new double[]{newProb, curNode});
                }
            }
            
        }
        return probList[end];
    }
    
}

/**
 * Notes: This should be a quite classical modification of the Dijkstra's Algorithm. 
 * Instead of finding the minimum distance, we look for the largest possibility. 
 * We need to keep track of the possibility of arriving at each node and also keep 
 * track of the nodes that we have visited. 
 * Once we have found a new possibility, we need to record that in the probability
 * list array and reflect that in the priority queue so that we can pick out the 
 * largest possibility each time. The priority queue is meant to help for this 
 * selection only. 
 */