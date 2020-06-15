/**
 * Problem 35: Search Insert Position
 * Prompt: Given a sorted array and a target value, return 
 * the index if the target is found. If not, return the index 
 * where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}

/**
 * Binary search: Maintain a left close right open 
 * interval such that elements in the interval are
 * all possible. Finally when low and high meet
 * the interval is of size 0 and return low is enough. 
 */