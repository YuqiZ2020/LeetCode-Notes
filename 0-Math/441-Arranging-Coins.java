/**
 * Problem 441: Arranging Coins
 * Prompt: You have a total of n coins that you want to 
 * form in a staircase shape, where every k-th row must have 
 * exactly k coins.
 * Given n, find the total number of full staircase rows that
 * can be formed.
 * n is a non-negative integer and fits within the range of 
 * a 32-bit signed integer.
 * Date: 07/01/2020
 */
class Solution {
    public int arrangeCoins(int n) {
        return (int) (-0.5 + Math.sqrt(0.25 + 2 * (long) n));
    }
}

/**
 * Notes: Use math formula to solve for the number of rows
 * and round down to integer. Note that we need
 * to prevent integer overflow by using long and by doing the
 * division first. 
 */