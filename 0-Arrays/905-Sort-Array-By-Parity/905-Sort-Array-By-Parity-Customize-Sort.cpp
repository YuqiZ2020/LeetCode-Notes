class Solution {
public:
    static bool compareNums(int a, int b) 
    { 
        return (a % 2 < b % 2); 
    }
    vector<int> sortArrayByParity(vector<int>& A) {
        vector<int> ans;
        int len = A.size();
        for (int i = 0; i < len; ++i)
            ans.push_back(A[i]);
        sort(ans.begin(), ans.end(), compareNums);
        return ans;
    }
};