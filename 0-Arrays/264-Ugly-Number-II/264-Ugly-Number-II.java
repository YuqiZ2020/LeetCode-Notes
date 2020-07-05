class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int cur2 = 0;
        int cur3 = 0;
        int cur5 = 0;
        for (int i = 1; i < n; ++i)
        {
            int t2 = uglyNums[cur2] * 2;
            int t3 = uglyNums[cur3] * 3;
            int t5 = uglyNums[cur5] * 5;
            if (t2 <= t3)
            {
                if (t2 <= t5)
                {
                    uglyNums[i] = t2;
                    cur2++;
                    if (t2 == t3)
                        cur3++;
                    if (t2 == t5)
                        cur5++;
                }
                else
                {
                    uglyNums[i] = t5;
                    cur5++;
                }
            }
            else
            {
                if (t3 <= t5)
                {
                    uglyNums[i] = t3;
                    cur3++;
                    if (t3 == t5)
                        cur5++;
                }
                else
                {
                    uglyNums[i] = t5;
                    cur5++;
                }
            }
        }
        return uglyNums[n - 1];
    }
}

/**
 * Notes: Every ugly number is some previous ugly number times 2, 3, or 5. 
 * If we keep track of some previous numbers' condition based on whether
 * we have tried multiplying it by 2, 3, or 5 then we could produce all
 * the numbers and keep them in sequence. 
 * Let there be 3 pointers that we hold, each representing the number we 
 * want to multiply by 2, 3 or 5. For a number and cur2, once the number i * 2
 * has been produced and added to the list, we no longer have to consider
 * this condition and can move the cursor pass that number. 
 * The same holds for the other cursors. That's why when 3 cursors all pass
 * one number i then all the possible multiplications have been generated. 
 */