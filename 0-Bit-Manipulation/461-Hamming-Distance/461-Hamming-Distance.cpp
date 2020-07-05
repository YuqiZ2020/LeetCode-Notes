class Solution {
public:
    int hammingDistance(int x, int y) {
        int t = x ^ y;
        int ans = 0;
        while (t)
        {
            t = t & (t - 1);
            ans++;
        }
        return ans;
    }
};

/**
 * Notice what t - 1 do is to find the first 1 that appear
 * on the right and flip that bit as well as any number
 * towards the right. Then when doing the & operation
 * those digits will all be gotten rid of, so we can get
 * rid of exactly one 1 digit each time. Then we count the 
 * number of 1. 
 * */