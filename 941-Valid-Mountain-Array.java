/**
 * Problem 941: Valid Mountain Array
 * Prompt: Given an array A of integers, return true if 
 * and only if it is a valid mountain array.
 * Recall that A is a mountain array if and only if:
 *      A.length >= 3
 *      There exists some i with 0 < i < A.length - 1 such that:
 *          A[0] < A[1] < ... A[i-1] < A[i]
 *          A[i] > A[i+1] > ... > A[A.length - 1]
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        int dir = 1;
        int flag = 1;
        if (A.length <= 2)
            return false;
        for (int i = 0; i < A.length - 1; ++i)
        {
            int t = (A[i + 1] - A[i]) * dir;
            if (t == 0)
                return false;
            if (t < 0)
            {
                if (i == 0)
                    return false;
                if (flag == 1)
                {
                    flag = 0;
                    dir = -1;
                }
                else 
                    return false;
            }
        }
        if (flag == 1)
            return false;
        return true;
    }
}

/**
 * Notes: Check edge cases; use a flag and a dir to note the direction
 * and make sure that the direction of ascending or descending only
 * change once over the entire array. 
 */