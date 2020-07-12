/**
 * Problem 1502: Can Make Arithmetic Progression From Sequence
 * Prompt: Given an array of numbers arr. A sequence of numbers is called 
 * an arithmetic progression if the difference between any two consecutive 
 * elements is the same.
 * Return true if the array can be rearranged to form an arithmetic 
 * progression, otherwise, return false.
 * Date: 07/04/2020
 */
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 2; i < arr.length; ++i)
        {
            if (arr[i] - arr[i - 1] != d)
                return false;
        }
        return true;
    }
}

/**
 * Notes: If we want constant differences between consecutive
 * numbers, we would always need a sorted one. So after we sort
 * it we can check, if it's wrong then it's not possible. 
 */