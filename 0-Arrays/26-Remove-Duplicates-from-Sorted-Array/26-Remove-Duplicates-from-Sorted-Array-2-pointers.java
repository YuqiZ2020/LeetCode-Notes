class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len;
        int cur1 = 1;
        int cur2 = 1;
        while (cur2 < len)
        {
            if (nums[cur2] != nums[cur1 - 1])
            {
                nums[cur1] = nums[cur2];
                cur1++;
            }
            cur2++;
        }
        return cur1;
    }
}

/**
 * The second cursor is the read cursor, and for each time, 
 * if nums[cur2] != nums[cur - 1], this is a new element
 * that needs to be stored in the new slot. Otherwise the 
 * cur2 simply moves forward. 
 */
