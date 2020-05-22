class Solution {
    public boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num)
            r = (num / r + r) / 2;
        if (r * r == num)
            return true;
        return false;
    }
}

/**
 * Notes: Use Newton's Method to approximate the solution
 * for f(r) = r^2 - num = 0
 * Choose r0 as num unitl we get the result
 */