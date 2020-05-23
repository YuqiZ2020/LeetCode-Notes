class Solution {
    public:
        string removeKdigits(string num, int k) {
            vector<int> numVec;
            int len = num.length();
            for (int i = 0; i < len; ++i)
                numVec.push_back((int) (num[i] - '0'));
            for (int i = 0; i < k; ++i)
            {
                int j = 0;
                while (j + 1 < numVec.size() && numVec[j] <= numVec[j + 1])
                    j++;
                numVec.erase(numVec.begin() + j);
            }
            stringstream ss;
            int j = 0;
            while (j < numVec.size() && numVec[j] == 0)
                j++;
            if (j == numVec.size())
                return "0";
            for (int i = j; i < numVec.size(); ++i)
                ss << numVec[i];
            return ss.str();
        }
    };