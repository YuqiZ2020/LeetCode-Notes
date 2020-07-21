class Solution {
public:
    double myPow(double x, int n) {
        if (n == INT_MIN)
        {
            if (x == 1 || x == -1)
                return 1;
            return 0;
        }
        if (n < 0)
            return 1 / myPow(x, -n);
        if (n == 0)
            return 1;
        if (n % 2 == 0)
            return myPow(x * x, n / 2);
        return x * myPow(x, n - 1);
        
    }
};

/**
 * Notes: The INT MIN is an edge case. 
 * If smaller than 0 then revert it. If zero
 * then return 1, if the number is a multiple
 * of two then we can doubling it, and divide n for
 * recursive call, otherwise we do one multiplication
 * and continue to get even exponent. 
 * */