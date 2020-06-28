/**
 * Problem 1493: Longest Subarray of 1's After Deleting One Element
 * Prompt: Given a binary array nums, you should delete one element 
 * from it.
 * Return the size of the longest non-empty subarray containing 
 * only 1's in the resulting array.
 * Return 0 if there is no such subarray.
 * Date: 06/27/2020
 */
class Solution {
    public int longestSubarray(int[] nums) {
        int sum = 0;
        List<Integer> processed = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i)
        {
            sum += nums[i];
            if (nums[i] == 0)
            {
                processed.add(sum);
                sum = 0;
            }
        }
        processed.add(sum);
        int ans = 0;
        if (processed.size() == 1)
            return Math.max(0, processed.get(0) - 1);
        for (int i = 0; i < processed.size() - 1; ++i)
        {
            int t = processed.get(i) + processed.get(i + 1);
            if  (t > ans)
                ans = t;
        }
        return ans;
    }
}

/**
 * Notes: Collapse all 1's when we meet a zero, and that 
 * zero will crash with those 1's. Save the collapsed number
 * into an array list. If we meet another zero but we have
 * nothing to collapse we need to save that number as well. 
 * Then we loop through the processed list, and for each time
 * we could at most add two numbers together (when we omit the zero
 * in between), and then we store the biggest value. 
 */