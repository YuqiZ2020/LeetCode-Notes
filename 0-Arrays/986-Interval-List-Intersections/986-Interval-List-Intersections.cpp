/**
 * Problem 986: Interval-List-Intersections
 * Prompt: Given two lists of closed intervals, each list of 
 * intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 * */
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

/**
 * Notes: Two pointers, first determine which interval is in fron of the other one
 * Then check if they overlap by comparing the tail of the first interval
 * with the head of the second interval. If they overlap, need to check where is 
 * the end of the overlap. 
 * Then move the pointer. 
 * */