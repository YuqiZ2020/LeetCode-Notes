/**
 * Problem 258: Add Digits
 * Prompt: Given a non-negative integer num, repeatedly add 
 * all its digits until the result has only one digit.
 * Date: 07/26/2020
 */
class Solution {
    public int addDigits(int num) 
    {
        if (num == 0)
            return 0;
        if (num % 9 == 0)
            return 9;
        return num % 9;
    }
}

/**
 * Notes: We know that n % 9 = (d0 + ... + dn) % 9
 * if (d0 + ... + dn) is not smaller than 10 then we can let this
 * be a number and do % 9 for it again to find the sum of its 
 * digit. This pattern can continue and we just keep do n % 9. 
 * So it will give us the final answer. However when n is a multiple
 * of 9 we need to consider it seperately becasue the sum will be
 * multiples of 9. 
 */