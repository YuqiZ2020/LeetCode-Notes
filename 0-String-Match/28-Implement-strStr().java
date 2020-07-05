/**
 * Problem 28: Implement strStr()
 * Return the index of the first occurrence of needle 
 * in haystack, or -1 if needle is not part of haystack.
 */
class Solution {
    public int strStr(String haystack, String needle) {
        //Next array
        if (needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        int[] next = new int[needle.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < needle.length(); ++i)
        {
            if (needle.charAt(i) == needle.charAt(j))
            {
                next[i] = j + 1;
                j++;
            }
            else if (j == 0)
                next[i] = 0;
            else
            {
                j = next[j - 1];
                i--;
            }
                
        }
        //Perform search
        j = 0;
        int i = 0;
        while (i < haystack.length())
        {
            if (haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
                if (j == needle.length())
                    return i - j;
            }
            else if (j == 0)
                i++;
            else
                j = next[j - 1];
        }
        return -1;
    }
}

/**
 * Notes: KMP algorithm. First implement next array
 * to store the max common pre-post-fix of the substring
 * from 0 - i as next[i]. 
 * Then perform the search with no trace back of i in O(n)
 */