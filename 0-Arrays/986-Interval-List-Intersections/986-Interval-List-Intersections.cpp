class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& A, vector<vector<int>>& B) {
        int i = 0;
        int j = 0;
        vector<vector<int>> ans;
        while (i < A.size() && j < B.size())
        {
            if (A[i][0] <= B[j][0])
            {
                if (A[i][1] >= B[j][0])
                {
                    if (A[i][1] >= B[j][1])
                    {
                        ans.push_back(vector<int> {B[j][0], B[j][1]});
                        j++;
                        continue;
                    }
                    ans.push_back(vector<int> {B[j][0], A[i][1]});
                }   
                i++;
            }
            else
            {
                if (A[i][0] <= B[j][1])
                {
                    if (A[i][1] <= B[j][1])
                    {
                        ans.push_back(vector<int> {A[i][0], A[i][1]});
                        i++;
                        continue;
                    }
                    ans.push_back(vector<int> {A[i][0], B[j][1]});
                }
                j++;
            }
        }
        return ans;
    }
};