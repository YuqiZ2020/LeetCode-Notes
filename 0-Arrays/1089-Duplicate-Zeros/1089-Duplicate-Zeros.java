/**
 * Problem 1089: Duplicate Zeros
 * Prompt: Given a fixed length array arr of integers, duplicate each 
 * occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 */

class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++){
            if(arr[i] == 0)
            {
                for(int j = len - 1; j > i; j--)
                    arr[j] = arr[j-1];
                i++;
            }
        }
    }
}

/**
 * Notes: Loop through the array and for each occurance of zero (at ith), 
 * move the sequential elements back by making the ith to the n - 1th 
 * element equal to its previous element (thus also duplicating the 0). 
 * Then move i forward by extra one and continue the loop. 
 */