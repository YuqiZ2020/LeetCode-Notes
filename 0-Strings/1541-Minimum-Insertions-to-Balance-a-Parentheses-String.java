/**
 * Problem 1541: Minimum Insertions to Balance a Parentheses String
 * Prompt: Given a parentheses string s containing only the 
 * characters '(' and ')'. A parentheses string is balanced if:
 * Any left parenthesis '(' must have a corresponding two consecutive 
 * right parenthesis '))'.
 * Left parenthesis '(' must go before the corresponding two 
 * consecutive right parenthesis '))'.
 * For example, "())", "())(())))" and "(())())))" are balanced, ")()", 
 * "()))" and "(()))" are not balanced.
 * You can insert the characters '(' and ')' at any position of the 
 * string to balance it if needed.
 * Return the minimum number of insertions needed to make s balanced.
 * Date: 08/09/2020
 */
class Solution {
    public int minInsertions(String s) {
        int cur = 0;
        int l = 0;
        int ans = 0;
        while (cur < s.length())
        {
            if (s.charAt(cur) == '(')
            {
                l++;
                cur++;
            }
            else
            {
                if (cur + 1 < s.length() && s.charAt(cur + 1) == ')')
                {
                    if (l > 0)
                        l--;
                    else
                        ans++;
                    cur += 2;
                }
                else
                {
                    if (l > 0)
                    {
                        l--;
                        ans++;
                    }
                    else
                        ans += 2;
                    cur++;
                }
            }
        }
        ans += l * 2;
        return ans;
    }
}

/**
 * Notes: I split this into 3 conditions:
 * 1. When we meet a '(' we increment l.
 * 2. When we meet a ')', we see if there is any left over '(' 
 * that we haven't used. If yes, we pair them and add extra 
 * ')'. If no we need to add extra '(' and ')' to match 
 * them up.
 * 3. When we meet a '))', we also see we see if there is any 
 * left over '(' that we haven't used. If yes, we match them. 
 * If no we need to add extra '('.
 */