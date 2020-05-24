/**
 * Problem 485: Max Consecutive Ones
 * Prompt: Given a binary array, find the maximum 
 * number of consecutive 1s in this array.
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int maxnum = -1;
        for (int i = 0; i < nums.length; ++i)
        {
            if (nums[i] == 1)
                counter++;
            else
            {
                if (counter > maxnum)
                    maxnum = counter;
                counter = 0;
            }
        }
        if (counter > maxnum)
            maxnum = counter;
        return maxnum;
    }
}

/**
 * Scan through and keep recording the max consecutive ones
 * with maxnum and a coutner. 
 */