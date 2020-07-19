/**
 * Problem 210. Course Schedule II
 * Prompt: There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have 
 * to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the
 * ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If 
 * it is impossible to finish all courses, return an empty array.
 * Date: 07/18/2020
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] ans = new int[numCourses];
        int c = 0;
        for (int i = 0; i < numCourses; ++i)
        {
            if (inDeg[i] == 0)
                nodeStack.push(i);
        }
        while (!nodeStack.isEmpty())
        {
            int u = nodeStack.pop();
            ans[c++] = u;
            visited[u] = true;
            while (!adjList[u].isEmpty())
            {
                int t = adjList[u].get(0);
                adjList[u].remove(0);
                if ((--inDeg[t]) == 0 && visited[t] == false)
                    nodeStack.push(t);
            }
        }
        if (c < numCourses - 1)
            return new int[0];
        return ans;
    }
}

/**
 * Notes: This is basically the same as problem 207, which uses
 * topological sort to determine if we could finish the course. 
 * Once a course has inDeg = 0 we push that to stack and see
 * if we can traverse all nodes. Meanwhile we maintain an 
 * extra array to store the nodes that we have visited. 
 */