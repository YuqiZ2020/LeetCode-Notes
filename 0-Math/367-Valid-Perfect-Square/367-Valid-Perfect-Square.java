/**
 * Problem 367: Valid Perfect Square
 * Prompt: Given a positive integer num, write a function which 
 * returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num >= i)
        {
            num = num - i;
            i+=2;
        }
        if (num == 0)
            return true;
        return false;
    }
}

/**
 * Notes: Any perfect square is the sum of consecutive odd integers
 * So keep creating odd integers starting from 1, 3, 5, 7...
 * and subtract until we get 0 or didn't get 0. 
 * Time complexity: O(sqrt(n))
 */