/**
 * Problem 62: Unique Paths
 * Prompt: A robot is located at the top-left corner of a 
 * m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any 
 * point in time. The robot is trying to reach the 
 * bottom-right corner of the grid (marked 'Finish' 
 * in the diagram below).
 * How many possible unique paths are there?
 * Date: 06/29/2020
 * */
class Solution {
public:
    int uniquePaths(int m, int n) {
        double ans = 1;
        for (int i = 1; i <= n - 1; ++i)
            ans = ans * (m + i - 1) / i;
        return (int) ans;
    }
};

/**
 * Notes: Use combination with stars and bars technique. 
 * We would have to take m + n - 2 steps, and the problem
 * is that which n - 1 of them would be the ones that move
 * down. So the formula is C(m + n - 2, n - 1)
 * However, we need to control the overflow of integer
 * multiplication, so we would need to do multiplication
 * and division together. And we need to start from 1 to
 * n - 1 to avoid precision error. 
 * */