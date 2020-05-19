/**
 * Problem 567: Permutation in String
 * Prompt: Given two strings s1 and s2, write a function to 
 * return true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations 
 * is the substring of the second string.
 * Date: 05/18/2020
 */
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        map<char, int> mmap;
        for (int i = 0; i < s1.length(); ++i)
            mmap[s1[i]]++;
        if (s2.length() < s1.length())
            return false;
        int winSt = 0;
        int winEd = 0;
        while (winEd < s2.length())
        {
            if (mmap.find(s2[winEd]) != mmap.end() && mmap[s2[winEd]] != 0)
            {
                if (winEd - winSt + 1 == s1.length())
                    return true;
                mmap[s2[winEd]]--;
                winEd++;
            }
            else if (winEd == winSt)
            {
                winEd++; 
                winSt++;
            }
            else
            {
                mmap[s2[winSt]]++;
                winSt++;
            }
        }
        return false;
    }
};

/**
 * Notes: Sliding window, same as problem 438. 
 * */