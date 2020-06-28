class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        map<int, int> numCount;
        for (int i = 0; i < arr.size(); ++i)
        {
            numCount[arr[i]]++;
        }
        map<int, int> freqMap;
        for (map<int, int>::iterator itr = numCount.begin(); 
            itr != numCount.end(); ++itr)
        {
            freqMap[itr->second]++;
        }
        int counter = 0;
        for (map<int, int>::iterator itr = freqMap.begin(); 
            itr != freqMap.end(); ++itr)
        {
            while (itr->first <= k && itr->second > 0)
            {
                k = k - itr->first;
                itr->second--;
            }
            counter = counter + itr->second;
            
        }
        return counter;
    }
};

/**
 * Notes: Use bucket sort to arrange the frequency count of all the
 * numbers. Then based on the frequency, decrease k until it reaches
 * 0 or can't be decreased. Then the final count of unique numbers is
 * the answer. 
 * */