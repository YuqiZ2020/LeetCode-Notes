/**
 * Problem 169: Majority Element
 * Prompt: Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority 
 * element always exist in the array.
 * */
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        map<int, int> numMap;
        int c = 0;
        for (vector<int>::const_iterator itr = nums.begin();
            itr != nums.end(); ++itr)
        {
            numMap[*itr]++;
            c++;
        }
        for (map<int, int>::const_iterator itr = numMap.begin();
             itr != numMap.end(); ++itr)
        {
            if (itr->second > (c/2))
                return itr->first;
        }
        return 0;
    }
};

/**
 * Note: Create a map that stores each number that occured as new key
 * and the frequency of occurance as the value. 
 * Then loop through the map to find the value that is more than the 
 * length of vector/2. 
 * Then return the value of the key. 
 * */