/**
 * Problem 79: Word Search
 * Prompt: Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * Date: 07/21/2020
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        for (int i = 0; i < board.length; ++i)
        {
            for (int j = 0; j < board[0].length; ++j)
            {
                if (start == board[i][j])
                {
                    if (dfs(board, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int idx)
    {
        if (idx == word.length())
            return true;
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || 
           board[i][j] != word.charAt(idx))
            return false;
        char temp = board[i][j];
        board[i][j] = '*';
        if (dfs(board, word, i - 1, j, idx + 1) || 
           dfs(board, word, i + 1, j, idx + 1) ||
           dfs(board, word, i, j - 1, idx + 1) || 
           dfs(board, word, i, j + 1, idx + 1))
        {
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}

/**
 * Notes: This way of search first then determine if out of bound can reduce time
 * to avoid TLE. This way if any direction is successful it just stops. 
 * Otherwise this is just a normal DFS problem. We find the candidate
 * of starting point by comparing the first value. Then we perform the search
 * for each direction. To avoid reusing element we can use '*' to replace and then
 * replace back after 4 direction's search. 
 */