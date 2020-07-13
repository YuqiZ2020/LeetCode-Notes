/**
 * Problem 190: Reverse Bits
 * Prompt: Reverse bits of a given 32 bits unsigned integer.
 * Date: 07/12/2020
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; ++i)
        {
            ans = ans << 1;
            ans = ans | (n & 1);
            n = n >> 1;
        }
        return ans;
    }
}

/**
 * Notes: Shift the answer to the left each time to determine
 * the current bit. If the right most digit of n is 1 then 
 * answer need to incorporate that without changing the previous
 * bits. Then shift n right to keep examine its right most bit. 
 */