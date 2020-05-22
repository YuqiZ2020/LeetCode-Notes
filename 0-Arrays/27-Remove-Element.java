/**
 * Problem 27: Remove Element
 * Prompt: Given an array nums and a value val, remove all 
 * instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must 
 * do this by modifying the input array in-place with O(1) 
 * extra memory.The order of elements can be changed. 
 * It doesn't matter what you leave beyond the new length.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            while (j < nums.length && nums[j] == val)
                j++;
            if (j >= nums.length)
                return i;
            nums[i] = nums[j];
            j++;
        }
        return nums.length;
    }
}

/**
 * Notes: Two pointers: one move from start and the other move 
 * from start but skip those that have value the same as val. 
 * Perform replacement until the second pointer is out of scope. 
 */