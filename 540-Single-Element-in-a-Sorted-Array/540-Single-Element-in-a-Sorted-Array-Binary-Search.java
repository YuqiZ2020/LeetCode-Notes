class Solution {
    public int singleNonDuplicate(int[] nums) {
       //Binary Search
        int len = nums.length;
        int leftn = 0;
        int rightn = len;
        int midn = leftn + (rightn - leftn) / 2;
        while (leftn < rightn)
        {
            if ((midn % 2 == 0 && midn + 1 < len && nums[midn + 1] == nums[midn])
            || (midn %2 == 1 && midn - 1 >= 0 && nums[midn - 1] == nums[midn]))
                leftn = midn + 1;
            else
                rightn = midn;
            midn = leftn + (rightn - leftn) / 2;
        }
        return nums[leftn];
        
    }
}

/**
 * Notes: Given a number, if the index is even and the rightside element is the same
 * as this element, that means the NonDuplicate is on the right; if the index is odd
 * and the leftside element is the same as this element, that means the NonDuplicate
 * is on the right. Otherwise the nonDuplicate is on the right. 
 * Then perform binary search until left reaches or goes over right. 
 */