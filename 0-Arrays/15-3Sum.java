/**
 * Problem 15: 3Sum
 * Prompt: Given an array nums of n integers, are there elements 
 * a, b, c in nums such that a + b + c = 0? Find all unique 
 * triplets in the array which gives the sum of zero.
 * Note:The solution set must not contain duplicate triplets.
 * Date: 07/08/2020
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i)
        {
            if (nums[i] > 0) break;
            if (i == 0 || nums[i] != nums[i - 1])
            {
                int sum = 0 - nums[i];
                int hi = nums.length - 1; int lo = i + 1;
                while (lo < hi)
                {
                    if (nums[lo] + nums[hi] == sum)
                    {
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    }
                    else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return ans;
    }
}

/**
 * Notes: First, sort the array. First when we fix a number, we can get the tarrget sum for
 * the rest of the two numbers. Then for the rest two numbers we can. Then for the rest
 * of the two numbers we can just use two pointers one from hi and one from low to pair them 
 * up. If we found the sum to be two small, we increase low, otherwise we increase high. 
 * In order to remove duplicate answers we have to move pointers when we find one target. 
 */