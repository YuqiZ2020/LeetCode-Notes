/**
 * Problem 1461: Check If a String Contains All Binary Codes of Size K
 * Prompt: Given a binary string s and an integer k.
 * Return True if all binary codes of length k is a substring of s. 
 * Otherwise, return False.
 * */
class Solution {
public:
    bool hasAllCodes(string s, int k) {
        if (k > s.length())
            return false;
        unordered_set <string> codeMap;
        for (int i = 0; i < s.length() - k + 1; ++i)
        {
            string t = s.substr(i, k);
            codeMap.insert(t);
        }
        if (codeMap.size() == (int) pow(2, k))
            return true;
        return false;
    }
};

/**
 * Notes: Use sliding window to save all the patterns
 * encountered in an unordered_set (save time), then 
 * in the end check the size of the set. 
 * */