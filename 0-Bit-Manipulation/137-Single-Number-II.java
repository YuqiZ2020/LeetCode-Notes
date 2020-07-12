/**
 * Problem 137: Single Number II
 * Prompt: Given a non-empty array of integers, every element appears 
 * three times except for one, which appears exactly once. 
 * Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * Date: 07/07/2020
 * */
class Solution {
    public int singleNumber(int[] nums) {
        int x1 = 0; int x2 = 0; int mask = 0;
        for (int i : nums)
        {
            x2 = x2 ^ (x1 & i);
            x1 = x1 ^ i;
            mask = ~(x2 & x1);
            x1 &= mask;
            x2 &= mask;
        }
        return x1;
    }
}

/**
 * Notes: Need to have multiples counters because the time
 * of occurance for other integers are more than twice. The number of 
 * counters should be determined by the number of apperance time in the
 * binary form (3 would require 2 digits, 5 would require 3 digits). 
 * Then we need to manipulate the first counter when we meet a i. We 
 * only manipulate the second counter when we meet a i and that this
 * i is presented in x1. 
 * We need a mask to turn counter back to 0 when meeting the number
 * for 3 times. The mask is chosen based on the binary representation
 * of the number 3. So the mask would be 0 when count of that number
 * is 3 and would be 1 when the count of that number is not 3. 
 * */