/**
 * Given a circular array C of integers represented by A, 
 * find the maximum possible sum of a non-empty subarray of C.
 * Here, a circular array means the end of the array connects
 * to the beginning of the array.  
 * (Formally, C[i] = A[i] when 0 <= i < A.length, and 
 * C[i+A.length] = C[i] when i >= 0.)
 * Also, a subarray may only include each element of the fixed
 * buffer A at most once.  (Formally, for a subarray C[i], 
 * C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j
 * with k1 % A.length = k2 % A.length.)
 */

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int cur_min = 0;
        int cur_max = 0;
        int ans_min = Integer.MAX_VALUE;
        int ans_max = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < A.length; ++i)
        {
            cur_max = cur_max + A[i];
            ans_max = Math.max(ans_max, cur_max);
            cur_max = Math.max(cur_max, 0);
            
            cur_min = cur_min + A[i];
            ans_min = Math.min(ans_min, cur_min);
            cur_min = Math.min(cur_min, 0);
            
            total += A[i];
        }
        if (ans_max < 0)
            return ans_max;
        else
            return Math.max(ans_max, total - ans_min);
    }
}

/**
 * Notes: DP, related to problem 53. 
 */