import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/**
 * Since there are more than half of the elements
 * being this majority element, once we sort them
 * we would get the middle one gaurenteed to be it. 
 */