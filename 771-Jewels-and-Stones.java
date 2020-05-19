/**
 * Problem: 771 Jewels and Stones
 * Prompt: You're given strings J representing the types of stones that are jewels, 
 * and S representing the stones you have.  Each character in S is a type of stone you have.  
 * You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. 
 * Letters are case sensitive. 
 * Date: 05/02/2020
 */

class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] arr = new int[123];
        for (int i = 0; i < S.length(); ++i)
            arr[(int) S.charAt(i)]++;
        int ans = 0;
        for (int i = 0; i < J.length(); ++i)
            ans = ans + arr[(int) J.charAt(i)];
        return ans;
    }
}

/**
 * Notes: Loop through the stone list first
 * Create an array, each represent the stone and store the count of stone
 * Then loop through the jewel list and add up the number of counts
 */