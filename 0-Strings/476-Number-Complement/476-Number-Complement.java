class Solution {
    public int findComplement(int num) {
        int i = 0;
        int j = 0;
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        return i - num;
    }
}

/**
 * Any binary representation of a number, its complement
 * is just the smallest number n of the form 11..11
 * minus that number. 
 * E.g. 94 = 1011110 -> 1111111 - 1011110 = 100001 = 33
 */