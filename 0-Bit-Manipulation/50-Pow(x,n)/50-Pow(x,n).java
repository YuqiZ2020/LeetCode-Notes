class Solution {
    public double myPow(double x, int n) {
        long l = Math.abs((long)n);
        double ans = 1.0;
        while (l > 0)
        {
            if ((l & 1) == 1)
                ans *= x;
            x *= x;
            l >>= 1;
        }
        if (n < 0)
            return 1.0 / ans;
        return ans;
    }
}

/**
 * Notes: The exponent can be viewed as a binary representation
 * and whether we do a multiplication of the exponent 
 * for a certain bit depends on whether that bit has 1 on it. 
 * For instance, the exponent is 5 = 101, so we can do multiplication
 * of x and then x^4. So x keeps squaring and we keep shifting
 * the exponent to find the place where we need multiplication. 
 * Need to convert to long to prevent negative integer overflow. 
 */