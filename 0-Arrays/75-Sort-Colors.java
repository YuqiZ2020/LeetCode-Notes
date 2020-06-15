/**
 * Problem 75: Sort Colors
 * Prompt: Given an array with n objects colored red, white 
 * or blue, sort them in-place so that objects of the same 
 * color are adjacent, with the colors in the order red, 
 * white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent 
 * the color red, white, and blue respectively.
 */
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high)
        {
            if (nums[mid] == 0)
            {
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            }
            else if (nums[mid] == 2)
            {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
            else
                mid++;
        }
    }
}

/**
 * Notes: This is a sort that utlizes switching of the elements. 
 * Maintain three pointers low, mid and high. Once mid found a 0
 * or a 2, it needs to swtich with low or high, once switching with
 * a low, we can increment low and mid directly because we know that
 * mid can only be 1 (we have checked 2 as we go further). Once we 
 * switched with high we can only decrease the high. Otherwise if it 
 * were a 1 just increment mid. 
 * Finally when mid and high meets we finished processing the array
 * becuse we have moved all the 0 before low, all the 2 after high and 
 * the numbers in between are just 1. 
 */