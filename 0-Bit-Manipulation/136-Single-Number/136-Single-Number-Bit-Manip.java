class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++)
		    ans = ans ^ nums[i];
	    return ans;
    }
}

/**
 * Notes: Any number XOR itself should be 0 and any number
 * XOR 0 should be this number. So if we XOR all numbers
 * together we should get the single number in our result. 
 */