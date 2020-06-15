/**
 * Problem 392: Is Subsequence
 * Prompt: Given a string s and a string t, check if s is 
 * subsequence of t.
 * A subsequence of a string is a new string which is formed 
 * from the original string by deleting some (can be none)
 * of the characters without disturbing the relative 
 * positions of the remaining characters. 
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk 
 * where k >= 1B, and you want to check one by one to see if 
 * T has its subsequence. In this scenario, how would you 
 * change your code?
 * Date: 06/09/2020
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int r = s.length();
        int c = t.length(); 
        if (r == 0)
            return true;
        if (c == 0)
            return false;
        boolean dp[][] = new boolean[r][c];
        if (s.charAt(0) == t.charAt(0))
            dp[0][0] = true;
        for (int i = 1; i < c; ++i)
            dp[0][i] = dp[0][i - 1] || s.charAt(0) == t.charAt(i);
        for (int i = 1; i < r; ++i)
        {
            for (int j = 1; j < c; ++j)
            {
                if (dp[i][j - 1])
                    dp[i][j] = true;
                else if (s.charAt(i) == t.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[r - 1][c - 1];
    }
}

/**
 * Notes: Dynamic Programming, Consider whether s[0...i] is a susequence
 * of t[0...j] for dp[i][j]. Note that if s[0...i] is a susequence
 * of t[0...j - 1], then dp[i][j] is automatically true. 
 * The other possibility is that the character at s[i] and t[j] is the same, 
 * while s[0...i - 1] is a susequence of t[0...j - 1]. 
 */