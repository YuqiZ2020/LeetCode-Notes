/**
 * Problem 994: Rotting Oranges
 * Prompt: In a given grid, each cell can have one of three values:
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) 
 * to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no 
 * cell has a fresh orange.  If this is impossible, return -1 
 * instead.
 * Date: 08/09/2020
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int goal = 0;
        for (int i = 0; i < r; ++i)
        {
            for (int j = 0; j < c; ++j)
            {
                if (grid[i][j] == 2)
                    q.offer(new Pair(i, j));
                else if (grid[i][j] == 1)
                    goal++;
            }
        }
        if (goal == 0)
            return 0;
        int ans = 0;
        while (!q.isEmpty())
        {
            int size = q.size();
            boolean flag = false;
            for (int i = 0; i < size; ++i)
            {
                Pair<Integer, Integer> cur = q.remove();
                int x = cur.getKey();
                int y = cur.getValue();
                if (x > 0 && grid[x - 1][y] == 1)
                {
                    grid[x - 1][y] = 2;
                    goal--;
                    q.offer(new Pair(x - 1, y));
                    flag = true;
                }
                if (x < r - 1 && grid[x + 1][y] == 1)
                {
                    grid[x + 1][y] = 2;
                    goal--;
                    q.offer(new Pair(x + 1, y));
                    flag = true;
                }
                if (y > 0 && grid[x][y - 1] == 1)
                {
                    grid[x][y - 1] = 2;
                    goal--;
                    q.offer(new Pair(x, y - 1));
                    flag = true;
                }
                if (y < c - 1 && grid[x][y + 1] == 1)
                {
                    grid[x][y + 1] = 2;
                    goal--;
                    q.offer(new Pair(x, y + 1));
                    flag = true;
                }
            }
            if (flag)
                ans++;
        }
        if (goal > 0)
            return -1;
        return ans;
    }
}

/**
 * Notes: Use BFS to simulate the rotting process. First put all
 * the rotted oranges into a queue. Then we need to pull out all the 
 * elements in the queue, because they affect the surrounding 
 * oranges together, and should be processed together. For each of 
 * them we determine their 4 positions and add any rotted ones
 * to the queue. We keep track of the successfully rotted orange, 
 * and see if all are processed in the end. 
 */