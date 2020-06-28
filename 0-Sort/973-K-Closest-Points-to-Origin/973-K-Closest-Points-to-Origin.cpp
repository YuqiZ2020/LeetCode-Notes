/**
 * Problem 973: K Closest Points to Origin
 * Prompt: We have a list of points on the plane. 
 * Find the K closest points to the origin (0, 0).(Here, the distance between
 * two points on a plane is the Euclidean distance.)
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in.)
 * Date: 05/31/2020
 * */
class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
        map<int, vector<int>> allPoints;
        for (int i = 0; i < points.size(); ++i)
        {
            int distSq = pow(points[i][0], 2) + pow(points[i][1], 2);
            allPoints[distSq].push_back(i);
        }
        vector<vector<int>> ans;
        int counter = 0;
        for (map<int, vector<int>>::const_iterator itr = allPoints.begin();
             itr != allPoints.end(); ++itr)
        {
            vector<int> t = itr->second;
            for (int i = 0; i < t.size(); ++i)
            {
                ans.push_back(points[t[i]]);
                counter++;
            }
            if (counter >= K)
                break;
        }
        return ans;
    }
};
/**
 * Notes: Use a map to store the key (distance) and value (vector of index 
 * whose corresponding point has that distance)
 * Since map is automatically sorted, we can iterate through and get the 
 * K first points
 * */