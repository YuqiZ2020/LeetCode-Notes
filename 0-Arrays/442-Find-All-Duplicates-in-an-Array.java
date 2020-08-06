/**
 * Problem 442: Find All Duplicates in an Array
 * Prompt: Given an array of integers, 1 ≤ a[i] ≤ n 
 * (n = size of array), some elements appear twice and 
 * others appear once.
 * Find all the elements that appear twice in this array.
 * Date: 08/06/2020
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i)
        {
            int cur = Math.abs(nums[i]) - 1;
            if (nums[cur] < 0)
                ans.add(cur + 1);
            else
                nums[cur] = -nums[cur];
        }
        return ans;
        
    }
}

/**
 * Notes: Since the prompt stated that the values in the array
 * would be between 1 and n, we could use negative values
 * to represent that a certian value has been presented in the 
 * array. Then if we meet a value that has already been turned
 * negative we know that this value has presented twice. 
 */