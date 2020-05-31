/**
 * Problem 207: Course Schedule
 * Prompt: There are a total of numCourses courses you have to take,
 * labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take
 * course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 * Given the total number of courses and a list of
 * prerequisite pairs, is it possible for you to finish all courses?
 * Date: 05/28/2020
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i)
            adjList[i] = new ArrayList<Integer>();
        int[] inDeg = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i)
        {
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
            inDeg[prerequisites[i][0]]++;
        }
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> nodeStack = new Stack<Integer>();
        for (int i = 0; i < numCourses; ++i)
        {
            if (inDeg[i] == 0)
                nodeStack.push(i);
        }
        while (!nodeStack.isEmpty())
        {
            int u = nodeStack.pop();
            visited[u] = true;
            while (!adjList[u].isEmpty())
            {
                int t = adjList[u].get(0);
                adjList[u].remove(0);
                if ((--inDeg[t]) == 0 && visited[t] == false)
                    nodeStack.push(t);
            }
        }
        for (int i = 0; i < numCourses; ++i)
        {
            if (visited[i] == false)
                return false;
        }
        return true;
    }
}

/**
 * Notes: Use topological sort for this problem to determine
 * if there are cycles in a graph. 
 * Use a stack and DFS for deleting nodes with 0 in degree
 * and finally see if there are any unvisited node. 
 * If not then this means that this connnected portion
 * doesn't have any cycle. 
 */