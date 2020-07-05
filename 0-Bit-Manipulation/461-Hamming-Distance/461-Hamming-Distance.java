/**
 * Problem 461: Hamming Distance
 * Prompt: The Hamming distance between two integers is the 
 * number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Date: 07/05/2020
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        String s = Integer.toBinaryString(t);
        int ans = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            if (s.charAt(i) == '1')
                ans++;
        }
        return ans;
    }
}

/**
 * Notes: Just a straightforward way to count how many
 * bits contain 1 in the XOR result. We can use the Integer.bitCount()
 * function as well. 
 */