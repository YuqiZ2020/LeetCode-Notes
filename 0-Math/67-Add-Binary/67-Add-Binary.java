/**
 * Problem 67: Add Binary
 * Prompt: Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Date: 07/19/2020
 */
class Solution {
    public String addBinary(String a, String b) {
        if (b.length() > a.length())
        {
            String t = a;
            a = b;
            b = t;
        }
        char[] arr = a.toCharArray();
        boolean carry = false;
        int j = a.length() - 1;
        for (int i = b.length() - 1; i >= 0; --i)
        {
            if (b.charAt(i) == '1')
            {
                if (arr[j] == '1')
                {
                    if (!carry)
                    {
                        carry = true;
                        arr[j] = '0';
                    }
                }
                else
                {
                    if (!carry)
                        arr[j] = '1';
                }
            }
            else if (carry)
            {
                if (arr[j] == '1')
                    arr[j] = '0';
                else
                {
                    arr[j] = '1';
                    carry = false;
                }
            }
            j--;
        }
        while (carry && j >= 0)
        {
            if (arr[j] == '1')
                arr[j] = '0';
            else
            {
                carry = false;
                arr[j] = '1';
            }
            j--;
        }
        if (!carry)
            return String.valueOf(arr);
        return '1' + String.valueOf(arr);
            
    }
}

/**
 * Notes: Do addition step by step from end to front. Need
 * to using different branches for different conditions on the 
 * addition of the one bit. 
 * In the end, if there are leftover carried number we need to 
 * concatenate that '1'. 
 */