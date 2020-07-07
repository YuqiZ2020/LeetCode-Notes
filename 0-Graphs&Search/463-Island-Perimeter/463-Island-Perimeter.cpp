class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int numIsland = 0;
        int neighbors = 0;
        int r = grid.size();
        int c = grid[0].size();
        for (int i = 0; i < r; ++i)
        {
            for (int j = 0; j < c; ++j)
            {
                if (grid[i][j] == 1)
                {
                    numIsland++;
                    if (i > 0 && grid[i - 1][j] == 1)
                        neighbors++;
                    if (j > 0 && grid[i][j - 1] == 1)
                        neighbors++;
                }
            }
        }
        return numIsland * 4 - neighbors * 2;
    }
};

/**
 * Notes: For any block it would have 4 perimeters, but
 * we will be double counting those that have neighbors. 
 * So we count for the upper and left neighbors and subtract
 * 2 times the amount of neighbors lines to get the final answer. 
 * */