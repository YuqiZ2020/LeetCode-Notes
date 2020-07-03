class Solution {
public:
    bool isPathCrossing(string path) {
        map<pair<int, int>, int> mMap;
        int x = 0;
        int y = 0;
        mMap[make_pair(0, 0)]++;
        for (int i = 0; i < path.length(); ++i)
        {
            if (path[i] == 'N')
                y++;
            else if (path[i] == 'S')
                y--;
            else if (path[i] == 'E')
                x++;
            else if (path[i] == 'W')
                x--;
            pair t = make_pair(x, y);
            mMap[t]++;
            if (mMap[t] > 1)
                return true;
        }
        return false;
    }
};

/**
 * Notes: A simulation of the problem as we record
 * all the points that we've been at. 
 * We record the points in a map, although we could
 * also use a set. 
 * */