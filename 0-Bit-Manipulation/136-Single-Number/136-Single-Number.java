/**
 * Problem 136: Single Number
 * Prompt: Given a non-empty array of integers, every element 
 * appears twice except for one. Find that single one.
 * Date: 05/02/2020
 */
import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2)
        {
            if (i == nums.length - 1)
                return nums[i];
            if (nums[i] != nums[i+1])
                return nums[i];
        }
        return 0;
    }
}

/**
 * Notes:
 * Sort the array first and loop through it on the 0, 2, 4... entry
 * If the number on the even entry is different from the odd entry
 * then that number is the single number
 * The other possible case is that the last number is the single number
 */