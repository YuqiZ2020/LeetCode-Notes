class Solution {
    public boolean isSubsequence(String s, String t) {
        int r = s.length();
        int c = t.length(); 
        if (r == 0)
            return true;
        if (c == 0)
            return false;
        int curS = 0;
        int curT = 0;
        while (curT < c)
        {
            if (t.charAt(curT) == s.charAt(curS))
            {
                curS++;
                if (curS == r)
                    return true;
            }
            curT++; 
        }
        return false;
    }
}

/**
 * Notes: Maintain two pointers. One for s and one for t. 
 * We keep moving curT forward until it reaches end. Meanwhile, 
 * for curS we don't move it until we find the corresponding
 * character for the character in t. If the cursor reaches the
 * end of s, then it is a subsequence. 
 */