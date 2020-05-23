class Solution {
public:
    string frequencySort(string s) {
        int charMap[256];
        memset(charMap,0,sizeof(charMap));
        int len = s.length();
        for (int i = 0; i < len; ++i)
            charMap[(int) s[i]]++;
        int x = 0;
        stringstream ss;
        while (x < len)
        {
            int max = 0;
            int index = -1;
            for (int i = 0; i < 255; ++i)
            {
                if (max < charMap[i])
                {
                    index = i;
                    max = charMap[i];
                }
            }
            if (index == -1)
                return ss.str();
            ss << string(max, (char) index);
            x = x + max;
            charMap[index] = 0;
        }
        return ss.str();
    }
};

/**
 * Don't need to create another frequency map because
 * the array is small enough that we can find the 
 * max freq by iteration each time. 
 * */