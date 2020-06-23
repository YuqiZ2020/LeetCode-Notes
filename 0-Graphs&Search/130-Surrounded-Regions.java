/**
 * Problem 130: Surrounded Regions
 * Prompt: Given a 2D board containing 'X' and 'O' (the letter O), 
 * capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that 
 * surrounded region.
 * Date: 06/17/2020
 */
class Solution {
    public void solve(char[][] board) {
        int nrow = board.length;
        if (nrow == 0)
            return;
        int ncol = board[0].length;
        for (int i = 0; i < nrow; ++i)
        {
            dfs(board, i, 0);
            dfs(board, i, ncol - 1);
        }
        for (int j = 0; j < ncol; ++j)
        {
            dfs(board, 0, j);
            dfs(board, nrow - 1, j);
        }
        for (int i = 0; i < nrow; ++i)
        {
            for (int j = 0; j < ncol; ++j)
            {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'P')
                    board[i][j] = 'O';
            }
        }
        
    }
    private void dfs(char[][] board, int r, int c)
    {
        if (board[r][c] == 'O')
        {
            board[r][c] = 'P';
            if (r - 1 > 0)
                dfs(board, r - 1, c);
            if (c - 1 > 0)
                dfs(board, r, c - 1);
            if (r + 1 < board.length)
                dfs(board, r + 1, c);
            if (c + 1 < board[0].length)
                dfs(board, r, c + 1);
        }
    }
}

/**
 * Notes: Since we can't directly tell which area is surrounded by X
 * because there are two many directions and conditions to consider, 
 * we can consider the question other way around. 
 * We can first select out the O that shouldn't be turned into X by 
 * starting the search from the boundary and find connected O. We
 * can mark them using another letter P. 
 * Then we turn all the other O into X and convert the P back to O. 
 */