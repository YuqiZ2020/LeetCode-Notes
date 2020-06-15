class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0 && ( n & (n-1)) == 0);
    }
}

/**
 * Since the binary representation of any power of two 
 * should be consists of only one 1 in the front and 
 * zeros following, n and n - 1 should be binary complement. 
 */