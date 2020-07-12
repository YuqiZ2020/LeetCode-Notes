/**
 * Problem 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * Prompt: Given an array nums, you are allowed to choose one 
 * element of nums and change it by any value in one move.
 * Return the minimum difference between the largest and smallest 
 * value of nums after perfoming at most 3 moves.
 * Date: 07/11/2020
 */
class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 4)
            return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int delta1 = nums[len - 1] - nums[3];
        int delta2 = nums[len - 4] - nums[0];
        int delta3 = nums[len - 2] - nums[2];
        int delta4 = nums[len - 3] - nums[1];
        int ans = Math.min(delta1, delta2);
        ans = Math.min(delta3, ans);
        ans = Math.min(delta4, ans);
        return ans;
    }
}

/**
 * Notes: After we sort the array, there are only 4 possibilities. This
 * is because we are actually getting rid of 3 numbers that can make
 * the difference between the largest and smallest number the smallest. 
 * Therefore we always want to get rid of some biggest or smallest number, 
 * otherwise there will be no effect. Since we only have 3 choices, there
 * are just 4 possibilities. We get rid of 3 - 0, 2 - 1, 1 - 2, or 0 - 3. 
 * And we compare the results to find the most optimal. 
 */