/**
 * Problem 66: Plus One
 * Prompt: Given a non-empty array of digits representing a 
 * non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit 
 * is at the head of the list, and each element in the array 
 * contain a single digit.
 * You may assume the integer does not contain any leading 
 * zero, except the number 0 itself.
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int i = digits.length - 1;
        while (carry == 1 && i >= 0)
        {
            int t = digits[i] + carry;
            carry = t / 10;
            digits[i] = t % 10;
            i--;
        }
        if (carry == 1)
        {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}

/**
 * Notes: The only occation when we need to increase one 
 * bit for the number is one the original number
 * is 9 or 99 or ... So the answer would always be 1 following
 * zeros, so we can simply create a new array for that. 
 * Otherwise we just do a carry on for the calculations. 
 */