/**
 * Problem 287: Find the Duplicate Number
 * Prompt: Given an array nums containing n + 1 integers where 
 * each integer is between 1 and n (inclusive), prove that at 
 * least one duplicate number must exist. Assume that there is 
 * only one duplicate number, find the duplicate one.
 * Date: 06/25/2020
 */
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length < 3)
            return nums[0];
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[fast];
        fast = nums[fast];
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        }
        fast = 0;
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

/**
 * Notes: This can be viewed as a linked list problem. The next element is 
 * just the number with index of the present number. Therefore, any duplicate
 * number will create a loop in the linked list. The duplicated number
 * will take a cursor back to the road that it once took. The rest is the
 * same as Linked List Cycle II. 
 */