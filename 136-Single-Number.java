/**
 * Problem 136: Single Number
 * Prompt: Given a non-empty array of integers, every element 
 * appears twice except for one. Find that single one.
 * Date: 05/03/2020
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