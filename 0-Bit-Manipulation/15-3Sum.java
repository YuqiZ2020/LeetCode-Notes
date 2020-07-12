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
 * Notes: First fix one number and find our target of the two sum, 
 * then search for the two sum in the rest of the array. 
 */