/**
 * Problem 231. Power of Two
 * Prompt: Given an integer, write a function to determine 
 * if it is a power of two.
 * Date: 06/08/2020
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        while (n != 1)
        {
            int t = n % 2;
            if (t != 0)
                return false;
            n = n / 2;
        }
        return true;
    }
}

/**
 * Constantly divide by 2 and check the remainder, until
 * we reach 1. Need to consider those smaller than or equal
 * to 0. 
 */