class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        if (len == 0)
            return ans;
        for (int i = 0; i < len; ++i)
            nums[nums[i] % len] += len;
        for (int i = 1; i < len; ++i)
        {
            if ((nums[i] / len) == 0 || nums[i] == len)
                ans.add(i);
        }
        if (nums[0] / len == 0)
            ans.add(len);
        return ans;
    }
}

/**
 * Notes: Think of a way to record in the original array
 * of whether we encountered a number already. 
 * One way is to record them by adding len to the corresponding
 * index, because this way we would still be able to retrieve
 * the information originally stored. 
 */