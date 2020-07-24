/**
 * Problem 260: Single Number III
 * Prompt: Given an array of numbers nums, in which exactly two elements 
 * appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.
 * Date: 07/23/2020
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int storage = 0;
        for (int i = 0; i < nums.length; ++i)
            storage ^= nums[i];
        storage &= -storage; // Get rightmost one bit
        int[] ans = new int[2];
        int n1 = 0;
        int n2 = 0;
        for (int n : nums)
        {
            if ((n & storage) == 0)
                n1 ^= n;
            else
                n2 ^= n;
        }
        ans[0] = n1;
        ans[1] = n2;
        return ans;
    }
}

/**
 * Notes: After we did XOR for all the numbers, we would have
 * the two single numbers mixed together. The way to seperate
 * them is to pick out a digit in the mixed value and see 
 * which number contributed to it (only one of them for sure). 
 * We can do storage &= -storage to select out the right most
 * bit because doing minus will flip all the digit and add
 * 1 to the answer, which will cause carry on and latter digits
 * will all be canceled out due to the fliping. 
 * Then we go over the list again and seperate numbers using 
 * AND based on that. 
 */