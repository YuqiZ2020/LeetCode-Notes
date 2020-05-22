class Solution {
    private int cmpMap(int[] m1, int[] m2)
    {
        for (int i = 0; i < m1.length; ++i)
        {
            if (m1[i] > m2[i])
                return 1;
            else if (m1[i] < m2[i])
                return -1;
        }
        return 0;
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); ++i)
        {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); ++i)
        {
            if (cmpMap(s1map, s2map) == 0)
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        if (cmpMap(s1map, s2map) == 0)
            return true;
        return false;
    }
}

/**
 * Use two maps to store the frequency of characters in 
 * the pattern and that in the current window
 * If the two map doesn't match, slide the window forward
 * and update the new frequency count by manipulating the 
 * frequency of the character at the front and at the 
 * end of the window. 
 */