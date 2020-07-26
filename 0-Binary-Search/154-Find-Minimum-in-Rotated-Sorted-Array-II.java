/**
 * Problem 154: Find Minimum in Rotated Sorted Array II
 * Prompt: Suppose an array sorted in ascending order is rotated 
 * at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element. The array may contain duplicates.
 * Date: 07/25/2020
 */
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi])
                hi = mid;
            else if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi--;
        }
        return nums[lo];
    }
}

/**
 * Notes: There are two situations to consider, one is with rotation, 
 * and the other is without rotation. We use binary search to look
 * at which interval we need to look for the smallest number. If
 * all is with rotation, then we can just divide into two portions, 
 * if mid < hi then use left, otherwise use right. However, once
 * we add the without rotation condition. Once we have mid == hi, 
 * we run into a contradiction of how to deal with it between this
 * and the previous situation. So we can only do hi-- because we 
 * know that this current one can be omitted (there are other same
 * ones in front of it. )
 */