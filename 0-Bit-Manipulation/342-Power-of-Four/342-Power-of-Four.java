/**
 * Problem: Power of Four
 * Prompt: Given an integer (signed 32 bits), write a function 
 * to check whether it is a power of 4.
 * Date: 08/06/2020
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        int i = 0;
        int k = 4;
        int t = 1;
        while (i < 15)
        {
            t += k;
            k *= 4;
            i++;
        }
         return (num > 0 && (num & (num - 1)) == 0 && ((num & t) == num));
    }
}

/**
 * Notes: First make sure that the number is bigger than 0. 
 * Second make sure that the number is power of two by 
 * examing that the number only has one 1 and the other bits
 * are all zero. Then we want to know if this 1 bit is 
 * in the correct posisition. It should only be in position
 * for 4, 16, 32, 256 ...
 */