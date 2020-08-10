/**
 * Problem 171: Excel Sheet Column Number
 * Prompt: Given a column title as appear in an Excel 
 * sheet, return its corresponding column number.
 * Date: 08/10/2020
 */
class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int c = 1;
        for (int i = s.length() - 1; i >= 0; --i)
        {
            ans += c * (s.charAt(i) - 'A' + 1);
            c *= 26;
        }
        return ans;
    }
}

/**
 * Notes: This is a base-26 number, which should be processed
 * just like any other base. 26^0 * n1 + 26^2 * n2 + ...
 */