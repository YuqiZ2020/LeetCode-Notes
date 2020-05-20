/**
 * Problem 26: Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place
 * such that each element appear only once and return the 
 * new length.
 * Do not allocate extra space for another array, 
 * you must do this by modifying the input array in-place 
 * with O(1) extra memory.
 * Date: 05/08/2020
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int cur1 = 0;
        int cur2 = 0;
        for (int i = 0; i < len; ++i)
        {
            while (cur2 < len && nums[cur1] == nums[cur2])
                cur2++;
            if (cur1 >= len)
                return i;
            nums[i] = nums[cur1];
            cur1 = cur2;
        }
        return len;
    }
}

/**
 * There are 2 cursors ahead to go through a segment of numbers
 * to record the newly found unique element, once found, 
 * that element is stored as nums[i]. 
 */