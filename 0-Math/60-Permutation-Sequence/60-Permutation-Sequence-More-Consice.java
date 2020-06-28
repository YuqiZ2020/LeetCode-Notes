class Solution {
    public String getPermutation(int n, int k) 
    {
        String ans = "";
        int[] factorial = new int[n + 1];
        List<Integer> numbers = new ArrayList<>();
        fac(n, factorial);
        for (int i = 1; i <= n; ++i)
            numbers.add(i);
        k--;
        for (int i = n - 1; i >= 0; --i)
        {
            int counter = k / factorial[i];
            k = k - counter * factorial[i];
            ans = ans + numbers.remove(counter);
        }
        return ans;
        
    }
    
    private void fac(int n, int[] fact)
    {
        fact[0] = 1;
        int res = 1;
        for (int i = 1; i <= n; ++i)
        {
            res = res * i;
            fact[i] = res;
        }
    }
    
}

/**
 * Notes: Since the permuation is given under dictionary order, 
 * Starting at the first position, each number will have factorial(n - 1)
 * times of occurance and follow with the next number. Then we try to get
 * the first number based on how many times we can move forward to next
 * number as long as we have enough steps given by k. 
 * Then the second number will have factorial(n - 2) occurances and so on. 
 * Notice that k means k steps so k can't be zero, so we subtract 1 from k at 
 * the beginning. 
 * This is some improvement for the last solution. Since we already subtract
 * 1, we can use divide rather than subtraction. We can use arraylist to 
 * remove numbers rather than using array to keep tract of them. 
 */