/**
 * Problem 463: Island Perimeter
 * Prompt: You are given a map in form of a two-dimensional integer grid 
 * where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one 
 * island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to 
 * the water around the island). One cell is a square with side length 1. 
 * The grid is rectangular, width and height don't exceed 100. Determine 
 * the perimeter of the island.
 * Date: 07/07/2020
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] ans = new int[1];
        for (int i = 0; i < grid.length; ++i)
        {
            for (int j = 0; j < grid[0].length; ++j)
            {
                if (grid[i][j] == 1)
                {
                    dfs(grid, visited, i, j, ans);
                    return ans[0];
                }
                    
            }
        }
        return 0;
    }
    public void dfs(int[][] g, boolean[][] visited, int i, int j, int[] c)
    {
        if (visited[i][j])
            return;
        visited[i][j] = true;
        if (i > 0)
        {
            if (g[i - 1][j] == 1)
                dfs(g, visited, i - 1, j, c);
            else
                c[0]++;
        }
        else
            c[0]++;
        if (i < g.length - 1)
        {
            if (g[i + 1][j] == 1)
                dfs(g, visited, i + 1, j, c);
            else
                c[0]++;
        }
        else
            c[0]++;
        if (j > 0)
        {
            if (g[i][j - 1] == 1)
                dfs(g, visited, i, j - 1, c);
            else
                c[0]++;
        }
        else
            c[0]++;
        if (j < g[0].length - 1)
        {
            if (g[i][j + 1] == 1)
                dfs(g, visited, i, j + 1, c);
            else
                c[0]++;
        }
        else
            c[0]++;  
    }
}

/**
 * Notes: Use dfs to search for surroundings and 
 * see if there are neighboring cells or boundaries. 
 */