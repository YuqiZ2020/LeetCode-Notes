/**
 * Problem 387: First Unique Character in a String
 * Prompt: Given a string, find the first non-repeating character 
 * in it and return it's index. If it doesn't exist, return -1.
 * Date: 05/05/2020
 */
import java.util.Arrays;

class Solution {
    public int firstUniqChar(String s) {
        int[] tempArr = new int[26];
        Arrays.fill(tempArr, 0);
        int[] locArr = new int[26];
        for (int i = 0; i < (int) s.length(); ++i)
        {
            int temp = s.charAt(i) - 97;
            tempArr[temp] ++;
            locArr[temp] = i;
        }
        int ans = s.length();
        for (int i = 0; i < 26; ++ i)
        {
            if (tempArr[i] == 1)
            {
                if (locArr[i] < ans)
                    ans = locArr[i];
            }
                
        }
        if (ans == s.length())
            return -1;
        return ans;
    }
}

/**
 * Note: loop through the string first and for each character (0-25), 
 * store its location and its frequency of occurance with two arrays. 
 * Then loop through the array with length 26 and find the one with
 * freq = 1 and output its location. 
 */