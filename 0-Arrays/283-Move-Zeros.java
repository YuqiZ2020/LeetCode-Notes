/**
 * Given an array nums, write a function to 
 * move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int cur1 = 0;
        int cur2 = 0;
        while (cur2 < len)
        {
            if (nums[cur2] != 0)
            {
                nums[cur1] = nums[cur2];
                cur1++;
            }
            cur2++;
        }
        for (int i = cur1; i < len; ++i)
            nums[i] = 0;
    }
}

/**
 * Notes: Two Pointers for read and write seperately, 
 * after writing all the non zero components, just
 * fill the rest with zeros. 
 */