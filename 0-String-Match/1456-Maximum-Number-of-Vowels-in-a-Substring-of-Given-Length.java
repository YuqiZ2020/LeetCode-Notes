/**
 * Problem 1456: Maximum Number of Vowels in a Substring of Given Length
 * Prompt: Given a string s and an integer k.Return the
 * maximum number of vowel letters in any substring of s with length k.
 */
class Solution {
    private boolean isVowels(char ch)
    {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int i = 0;
        int num = 0;
        for (i = 0; i < k; ++i)
        {
            if (isVowels(s.charAt(i)))
                num++;
        }
        int ans = num;
        for (i = 1; i <= s.length() - k; ++i)
        {
            if (isVowels(s.charAt(i - 1)))
                num--;
            if (isVowels(s.charAt(i + k - 1)))
                num++;
            if (num > ans)
                ans = num;
        }
        return ans;
    }
}

/**
 * Notes: num is used to record the number of vowels 
 * for each window position and ans is used to record 
 * the maximum of num throughout the process.
 * Whenever the window moves, it updates the num by 
 * making changes based on the one character we left 
 * behind and the one character that is added. 
 * If the one we left behind is a vowel, then num--. 
 * If the one newly added is a vowel, then num++.
 */