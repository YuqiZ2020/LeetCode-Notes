/**
 * Problem 525: Contiguous Array
 * Prompt: Given a binary array, find the maximum length
 * of a contiguous subarray with equal number of 0 and 1.
 * Date: 05/26/2020
 */
class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] count = new int[len * 2 + 1];
        Arrays.fill(count, -1);
        int temp = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            temp = temp + nums[i];
            if (nums[i] == 0)
                temp--; 
            if (count[temp + len] != -1)
            {
                int num = i - count[temp + len];
                if (num > ans)
                    ans = num;
            }
            else
                count[temp + len] = i;
            if (temp == 0 && i + 1 > ans)
                ans = i + 1;
        }
        return ans;
    }
}

/**
 * Notes: First use an array to count the occurance of 0 and -1. 
 * When encounter 0, add -1, and when encounter 1, add 1. 
 * Then when the counter is 0, that means we have equal number
 * of 0 and 1 starting from the 0 index to current i index. 
 * Another condition is that when two index have the same
 * count value. That means these two index make a contiguous array
 * that have same number of 0 and 1. 
 * Once we get a count value, we want to find if it has already
 * occured in the count array, which store the index of a certain
 * count. If doesn't exsit, we update that; if exist, then we
 * calculate the length without updating. 
 * Store the max length of these two conditions. 
 */