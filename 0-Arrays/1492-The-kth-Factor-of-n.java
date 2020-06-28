class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> fac = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); ++i)
        {
            if (n % i == 0)
                fac.add(i);
        }
        int len = fac.size();
        if (len >= k)
            return fac.get(k - 1);
        else
        {
            int t = (int) (Math.sqrt(n));
            if (t * t == n)
            {
                if (len * 2 - 1 >= k)
                    return n / fac.get(len * 2 - k - 1);
                else
                    return -1;
            }
            if (len * 2 >= k)
                return n / fac.get(len * 2 - k);
            else
                return -1;
        }
    }
}

/**
 * Notes: Since the factors of a number is symmetric, we can just
 * look at the first half of the factors. If k is within this range
 * then we directly get the kth factor. 
 * Other wise we see if k is in the other half of the factors. Notice
 * that if the number is a perfect square then the length of the factor
 * is odd number so there are two different cases. Either way we could
 * get the factor by doing division for the symmetric counter part. 
 */