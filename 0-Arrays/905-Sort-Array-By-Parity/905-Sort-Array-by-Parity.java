/**
 * Problem 905: Sort Array by Parity
 * Prompt: Given an array A of non-negative integers, 
 * return an array consisting of all the even elements 
 * of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies 
 * this condition.
 */

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int cur1 = 0;
        int cur2 = 1;
        while (cur2 < A.length)
        {
            while (cur1 < A.length && A[cur1] % 2 == 0)
                cur1++;
            while (cur2 < A.length && A[cur2] % 2 == 1 || cur2 < cur1)
                cur2++;
            if (cur1 > cur2 || cur2 >= A.length)
                break;
            int temp = A[cur1];
            A[cur1] = A[cur2];
            A[cur2] = temp;
        }
        return A;
    }
}

/**
 * Use two pointers to read. If the first one is odd but the second one
 * is even then swap them. Need to make sure that the second cursor is 
 * staying further than the first cursor. 
 * If finally the second cursor is still before the first one or that 
 * the second one has already reach the end of the array, that means
 * we finish manipulating the array. 
 */