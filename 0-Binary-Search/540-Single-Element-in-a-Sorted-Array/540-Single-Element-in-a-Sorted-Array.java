/**
 * Problem 540: Single Element in a Sorted Array
 * You are given a sorted array consisting of only integers where 
 * every element appears exactly twice, except for one element
 * which appears exactly once. Find this single element that 
 * appears only once.
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
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
 * Notes: Same as Problem 136
 */