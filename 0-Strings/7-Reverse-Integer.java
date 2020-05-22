/**
 * Problem 7: Reverse Integer
 * Prompt: Given a 32-bit signed integer, reverse digits of an integer.
 * Date: 04/19/2020
 */
class Solution {
    public int reverse(int x) {
        String s1 = Integer.toString(x);
        int len = s1.length();
        StringBuilder ans = new StringBuilder(); 
        int t = 0;
        if (s1.charAt(0) == '-')
        {
            ans.append('-');
            t = 1;
        }
        for (int i = len - 1; i >= t; --i)
            ans.append(s1.charAt(i));
        long res = Long.parseLong(ans.toString());
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
            return 0;
        else 
            return Integer.valueOf(ans.toString());
    }
}

/**
 * Notes: First convert the integer to string
 * then use a string builder to concatnate the characters of
 * the string reversely. Then use long type to determine 
 * integer overflow. 
 * Finally convert the valid integer back to int and return. 
 */