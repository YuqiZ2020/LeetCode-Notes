class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++) 
        {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0)
                nums[val] = -nums[val];
        }
        
        for(int i = 0; i < len; i++) 
        {
            if(nums[i] > 0)
                ans.add(i + 1);
        }
        return ans;
    }
}

/**
 * Notes: Use negative numbers as flags to indicate
 * whether we have encountered the number. 
 */