/**
 * Problem 1299: Replace Elements with Greatest Element on Right Side
 * Prompt: Given an array arr, replace every element in that array with
 * the greatest element among the elements to its right, and replace 
 * the last element with -1.
 */
class Solution {
    public int[] replaceElements(int[] arr) {
        int maxVal = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; --i)
        {
            int temp = 0;
            if (arr[i] > maxVal)
            {
                temp = arr[i];
                arr[i] = maxVal;
                maxVal = temp;
            }
            else
                arr[i] = maxVal;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}

/**
 * Loop through the array from back to front and store the max value
 * seen so far for replacement. 
 */