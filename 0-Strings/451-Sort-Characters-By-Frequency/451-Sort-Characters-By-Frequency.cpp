#include <string>
#include <map>
#include <sstream>
#include <vector>

using std::string;
using std::map;
using std::vector;
using std::stringstream;
/**
 * Problem 451: Sort Characters By Frequency
 * Prompt: Given a string, sort it in decreasing 
 * order based on the frequency of characters.
 * Date: 05/22/2020
 * */
class Solution {
public:
    string frequencySort(string s) {
        int charMap[256];
        memset(charMap,0,sizeof(charMap));
        map<int, vector<char>> freqMap;
        for (int i = 0; i < s.length(); ++i)
            charMap[(int) s[i]]++;
        for (int i = 0; i < 255; ++i)
        {
            if (charMap[i] != 0)
                freqMap[charMap[i]].push_back((char) i);
        }
        stringstream ss;
        for (map<int, vector<char>>::reverse_iterator itr = freqMap.rbegin();
            itr != freqMap.rend(); ++itr)
        {
            for (int i = 0; i < itr->second.size(); ++i)
            ss << string(itr->first, itr->second[i]);
        }
        return ss.str();
    }
};

/**
 * Notes: First iterator through string and store the frequency of 
 * the characters using a HashMap Array. Then loop through that array
 * to record the frequency in a map with integer frequency as key
 * and the vector of character that has that frequency as the value. 
 * Then reversely output the map with correct count of each character. 
 * */