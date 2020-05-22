class Solution {
    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int ans = 0;
        for (int i = 1; i < r; ++i)
        {
            for (int j = 1; j < c; ++j)
            {
                int cur = 0;
                if (matrix[i][j] != 0)
                {
                    cur = Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]) + 1;
                    cur = Math.min(matrix[i][j - 1] + 1, cur);
                    matrix[i][j] = cur;
                }
                ans += cur;
            }
        }
        for (int i = 0; i < r; ++i)
            ans += matrix[i][0];
        for (int j = 1; j < c; ++j)
            ans += matrix[0][j];
        return ans;
    }
}