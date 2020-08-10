/**
 * Problem 1540: Can Convert String in K Moves
 * Prompt: Given two strings s and t, your goal is to convert s 
 * into t in k moves or less.
 * During the ith (1 <= i <= k) move you can:
 * Choose any index j (1-indexed) from s, such that 1 <= j <= s.length 
 * and j has not been chosen in any previous move, and shift the 
 * character at that index i times.
 * 1. Do nothing.
 * 2. Shifting a character means replacing it by the next letter in 
 * the alphabet (wrapping around so that 'z' becomes 'a'). Shifting a 
 * character by i means applying the shift operations i times.
 * Remember that any index j can be picked at most once.
 * Return true if it's possible to convert s into t in no more than k
 * moves, otherwise return false.
 * Date: 08/08/2020
 * */
class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        map<int, int> freqMap;
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); ++i)
        {
            int dist = t[i] - s[i];
            if (dist < 0)
                dist += 26;
            if (dist > 0)
                freqMap[dist]++;
        }
        int c[26] = {0};
        int baseline = k / 26;
        for (int i = 1; i < 26; ++i)
        {
            c[i] = baseline;
            if (k - baseline * 26 >= i)
                c[i]++;
        }
        for (map<int, int>::iterator itr = freqMap.begin(); 
            itr != freqMap.end(); ++itr)
        {
            if (itr->second > c[itr->first])
                return false;
        }
        return true;
    }
};

/**
 * Notes: The constraints doesn't specified the length difference 
 * of the two strings, so need to compare that
 * We are only changing s into t, not two sided, so dist = t[i] - s[i];
 * Negative distance can be resolved by wrapping around (+26)
 * Check the max occurances of each type of distance, and see if any 
 * occurances is bigger than its corresponding max value. 
 * */