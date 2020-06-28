/**
 * Problem 60: Permutation Sequence
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, 
 * we get the following sequence for n = 3. 
 * Given n and k, return the kth permutation sequence.
 */
class Solution {
    public String getPermutation(int n, int k) 
    {
        String ans = "";
        boolean[] flag = new boolean[n + 1];
        for (int i = n - 1; i > 0; --i)
        {
            int t = fac(i);
            int counter = 0;
            while (k - t > 0)
            {
                k = k - t;
                counter++;
            }
            int j = 1; 
            while (counter > 0)
            {
                if (!flag[j])
                    counter--;
                j++;
            }
            while (j < n && flag[j])
                j++;
            flag[j] = true;
            ans = ans + j;
        }
        int j = 1;
        while (j < n && flag[j])
            j++;
        ans = ans + j;
        return ans;
    }
    
    private int fac(int num)
    {
        int res = 1;
        for (int i = 2; i <= num; ++i)
        {
            res = res * i;
        }
        return res;
    }
    
}

/**
 * Notes: Since the permuation is given under dictionary order, 
 * Starting at the first position, each number will have factorial(n - 1)
 * times of occurance and follow with the next number. Then we try to get
 * the first number based on how many times we can move forward to next
 * number as long as we have enough steps given by k. 
 * So we subtract the steps from k until we can't (k shouldn't be zero or
 * less). We need to make sure that we are not selecting duplicated numbers
 * by keeping a flag for each of them. 
 * Then the second number will have factorial(n - 2) occurances and so on.
 */