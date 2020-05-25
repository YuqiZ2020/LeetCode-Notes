/**
 * Problem 414: Third Maximum Number
 * Prompt: Given a non-empty array of integers, return the 
 * third maximum number in this array. If it does not exist, 
 * return the maximum number. 
 * The time complexity must be in O(n).
 */
class Solution {
    public int thirdMax(int[] nums) {
        long first=Long.MIN_VALUE;
        long second=Long.MIN_VALUE;
        long third=Long.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i)
        {
            if (nums[i] > first)
            {
                third = second;
                second = first;
                first = nums[i];
            }
            else if (nums[i] == first)
                continue;
            else if (nums[i] > second)
            {
                third = second;
                second = nums[i];
            }
            else if (nums[i] == second)
                continue;
            else if (nums[i] > third)
                third = nums[i];
        }
        if (third != Long.MIN_VALUE)
            return (int) third;
        else
            return (int) first;
    }
}

/**
 * Notes: Compare and save. 
 */