/**
 * Problem 438: Find All Anagrams in a String
 * Prompt: Given a string s and a non-empty string p, 
 * find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only 
 * and the length of both strings s and p will not be 
 * larger than 20,100.
 * Date: 05/17/2020
 * */
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        map<char, int> mmap;
        vector<int> ans;
        if (p.length() > s.length())
            return ans;
        for (int i = 0; i < p.length(); ++i)
            mmap[p[i]]++;
        int winSt = 0;
        int winEd = 0; 
        while (winEd < s.length())
        {
            if (mmap.find(s[winEd]) != mmap.end() && mmap[s[winEd]] != 0)
            {
                mmap[s[winEd]] --;
                winEd++;
                if (winEd - winSt == p.length())
                    ans.push_back(winSt);
            }
            else if (winSt == winEd)
            {
                winSt ++;
                winEd ++;
            }
            else
            {
                mmap[s[winSt]]++;
                winSt++;
            } 
        }
        return ans;
    }
};

/**
 * Notes: The sliding window approach which has O(n) 
 * time complexity. There are two pointers, start and end,
 * which both starts at zero. 
 * There are 3 conditions:
 * 1. winEd points at a valid position
 *      need to record this in the map
 *      1) if the size of window is valid, then it is a 
 *         valid anagram
 * 2. winEd == winSt
 *      2) They both move forward
 * 3. winSt move forward and "return the value to the map"
 * because the window is leaving
 * While loop ends when winEd reaches the end
 * 
 * This is actually a strange implementation...
 * */