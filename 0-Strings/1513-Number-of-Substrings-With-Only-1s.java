class Solution {
    public int numSub(String s) {
        long counter = 0;
        long modulo = 1000000007;
        long ans = 0;
        long temp = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            if (s.charAt(i) == '0')
            {
                temp = counter * (counter + 1) / 2;
                ans = (ans + temp % modulo) % modulo;
                counter = 0;
            }
            else
                counter ++;
        }
        temp = counter * (counter + 1) / 2;
        ans = (ans + temp % modulo) % modulo;
        return (int) ans;
    }
}

/**
 * Notes: A string with length k has k * (k + 1) / 2 substrings. 
 * Use this trick to implement the algorithm. But need to do lots
 * of things when adding and multiplying. 
 */