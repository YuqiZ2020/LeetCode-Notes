class Solution {
    public int[] countBits(int num) {
        int[] countBitArray = new int[num + 1];
        for (int i = 1; i <= num; i++) 
            countBitArray[i] = countBitArray[i >> 1] + i % 2;
        return countBitArray;
    }
}

/**
 * Notes: Shift 1 digit to right is the remaining digits besides
 * the right most digit, and we just need to determine
 * the right most digit based on parity
 */
