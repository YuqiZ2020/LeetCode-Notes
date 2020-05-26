class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& A, vector<vector<int>>& B) {
        int i = 0;
        int j = 0;
        vector<vector<int>> ans;
        while (i < A.size() && j < B.size())
        {
            int st = max(A[i][0], B[j][0]);
            int ed = min(A[i][1], B[j][1]);
            if (st <= ed)
                ans.push_back(vector<int> {st, ed});
            if (A[i][1] <= B[j][1])
                i++;
            else
                j++;
        }
        return ans;
    }
};

/**
 * Notes: For any two given interval, check if they can intersect. 
 * First get the max of their end index, then get the min of their 
 * start index. If this start is smaller than or equal to this end, 
 * then they can intersect. Then move the pointer that is in the front
 * to the next interval. 
 * */