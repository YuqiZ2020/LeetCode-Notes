/**
 * Problem 72: Edit Distance
 * Prompt: Given two words word1 and word2, find the minimum 
 * number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * Date: 05/31/2020
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        if (len1 * len2 == 0)
            return (len1 + len2);
        for (int i = 0; i < len1 + 1; ++i)
            dp[i][0] = i;
        for (int j = 0; j < len2 + 1; ++j)
            dp[0][j] = j;
        for (int i = 1; i < len1 + 1; ++i)
        {
            for (int j = 1; j < len2 + 1; ++j)
            {
                int t = 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    t = 0;
                int temp = Math.min(dp[i - 1][j - 1] + t, dp[i - 1][j] + 1);
                temp = Math.min(temp, dp[i][j - 1] + 1);
                dp[i][j] = temp;
            }
        }
        return dp[len1][len2];
    }
}

/**
 * Notes: DP
 * Assume we are doing word1 horizontal, word2 vertical, and we are 
 * editing word2 to become word1. (Either way would work)
 * Three Operations each relate to a previous condition. When one way 
 * is to proceed from the top left corner, where the two sequences 
 * are up till the second till last element. If the last element is 
 * the same then the edit cost is the same, other wise need extra cost
 * for replacement. 
 * The other way is to increment one letter from word2 to word1, which is
 * moving from top to current. 
 * The third way is to delete one letter from word2 to word1, which is
 * moving from left to current. 
 */