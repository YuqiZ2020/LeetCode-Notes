class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i < num + 1; ++i)
        {
            if (i % 4 == 0)
            {
                String temp = Integer.toString(i, 2);
                int t = 0;
                for (int j = 0; j < temp.length(); ++j)
                {
                    if (temp.charAt(j) == '1')
                        t++;
                }
                ans[i] = t;
            }
            else if (i % 2 == 0)
                ans[i] = ans[i - 1];
            else
                ans[i] = ans[i - 1] + 1;
        }
        return ans;
    }
}

/**
 * Notes: Seperate into different conditions to consider
 * based on observation of the pattern. 
 * If odd, then just previous answer plus one, 
 * if multiple of 4, then directly calculate. 
 * If other multiples of 2, then same are previous. 
 */