/**
 * Problem 1471: The k Strongest Values in an Array
 * Prompt: Given an array of integers arr and an integer k.
 * A value arr[i] is said to be stronger than a value arr[j] 
 * if |arr[i] - m| > |arr[j] - m| where m is the median 
 * of the array.
 * If |arr[i] - m| == |arr[j] - m|, then arr[i] is said to 
 * be stronger than arr[j] if arr[i] > arr[j].
 * Return a list of the strongest k values in the array. 
 * return the answer in any arbitrary order.
 * Median is the middle value in an ordered integer list. 
 * More formally, if the length of the list is n, the median 
 * is the element in position ((n - 1) / 2) in the sorted 
 * list (0-indexed).
 * Date: 06/06/2020
 */
class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int medIdx = (arr.length - 1) / 2;
        int[] ans = new int[k];
        int i = 0;
        int cur1 = 0;
        int cur2 = arr.length - 1;
        while (i < k)
        {
            int dist1 = arr[medIdx] - arr[cur1];
            int dist2 = arr[cur2] - arr[medIdx];
            if (dist1 > dist2)
            {
                ans[i] = arr[cur1];
                cur1++;
            }
            else
            {
                ans[i] = arr[cur2];
                cur2--;
            }
            i++;         
        }
        return ans;
    }
}

/**
 * Notes: First sort the array to find the median, then maintain two pointers
 * that start from the beginning and end to compare the distance from that 
 * number to the median and find the larger ones to store into the ans array. 
 * Do this until we reach the desired number. 
 */