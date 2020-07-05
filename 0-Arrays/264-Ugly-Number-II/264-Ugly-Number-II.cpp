class Solution {
public:
    int nthUglyNumber(int n) {
        int uglyNums[n];
        uglyNums[0] = 1;
        int cur2 = 0;
        int cur3 = 0;
        int cur5 = 0;
        for (int i = 1; i < n; ++i)
        {
            int t2 = uglyNums[cur2] * 2;
            int t3 = uglyNums[cur3] * 3;
            int t5 = uglyNums[cur5] * 5;
            int minNum = min(t2, t3);
            minNum = min(minNum, t5);
            uglyNums[i] = minNum;
            if (minNum == t2)
                cur2++;
            if (minNum == t3)
                cur3++;
            if (minNum == t5)
                cur5++;
        }
        return uglyNums[n - 1];
    }
};

/**
 * Notes: This is a more consise version of the solution. 
 * By doing comparision we can omit the long conditional
 * branches. 
 * */

