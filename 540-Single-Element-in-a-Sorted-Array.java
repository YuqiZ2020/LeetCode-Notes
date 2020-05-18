/**
 * Problem 540: Single Element in a Sorted Array
 * You are given a sorted array consisting of only 
 * integers where every element appears exactly twice, 
 * except for one element which appears exactly once. 
 * Find this single element that appears only once.
 * Follow up: Your solution should run in O(log n) time and O(1) space.
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
       //Binary Search
        int len = nums.length;
        int leftn = 0;
        int rightn = len;
        int midn = leftn + (rightn - leftn) / 2;
        while (leftn < rightn)
        {
            if ((midn % 2 == 0 && midn + 1 < len && nums[midn + 1] == nums[midn])
            || (midn %2 == 1 && midn - 1 >= 0 && nums[midn - 1] == nums[midn]))
                leftn = midn + 1;
            else
                rightn = midn;
            midn = leftn + (rightn - leftn) / 2;
        }
        return nums[leftn];
        
    }
}

/**
 * Notes: Use binary search. For each midn, check if it is an odd
 * or even index. Then use the forward or backward element to decide
 * whether the single number is on the right or left and continue
 * the search. 
 */