class Solution {
    private int checkSubStr(String s, int cur, int[] l, int[] r)
    {
        int right = r[s.charAt(cur) - 'a'];
        for (int j = cur; j <= right; ++j)
        {
            if (l[s.charAt(j) - 'a'] < cur)
                return -1;
            right = Math.max(right, r[s.charAt(j) - 'a']);
        }
        return right;
    }
    public List<String> maxNumOfSubstrings(String s) {
        int[] l = new int[26];
        int[] r = new int[26];
        Arrays.fill(l, s.length());
        for (int i = 0; i < s.length(); ++i)
        {
            int cur = s.charAt(i) - 'a';
            l[cur] = Math.min(l[cur], i);
            r[cur] = i;
        }
        int right = -1;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i)
        {
            if (i == l[s.charAt(i) - 'a'])
            {
                int newRight = checkSubStr(s, i, l, r);
                if (newRight != -1)
                {
                    if (i <= right)
                        ans.remove(ans.size() - 1);
                    ans.add(s.substring(i, newRight + 1));
                    right = newRight;
                }
            }
        }
        return ans;
    }
}

/**
 * Notes: This is a greedy algorithm. First look for the left most
 * occurance and right most occurance of all the letters.
 * For each of the letter that is the first occurance, we can check
 * if it could be the beginning of a valid substring. (Otherwise it 
 * mustn't be). We can check if any number on the right has first occurance
 * earlier than this occurance. We can always enlarge the right bound of 
 * our substring by including the right most occurance of the current 
 * number. Then we return this right bound. 
 * If our new interval happen to lie inside the last old interval, we can
 * simply update it. (This new interval can not partially overlap, because
 * if this new interval must extend to outside region, then it contracdict
 * with the fact that there could be a valid interval that ends earlier). 
 * Otherwise the intervals don't overlap and we just append it. 
 */