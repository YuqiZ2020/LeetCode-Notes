class Solution {
public:
    bool isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
};

/**
 * 4^n = (2^n - 1)(2^n + 1), and we know that among any 3 consecutive
 * numbers, there must be 1 that is a multiple of 3. 2^n is not a 
 * multiple of 3, so either one of these must be. Then 4^n must be
 * a multiple of 3. 
 * */