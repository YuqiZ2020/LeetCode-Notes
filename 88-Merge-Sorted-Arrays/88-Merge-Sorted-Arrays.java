/**
 * Problem 88: Merge Sorted Arrays
 * Prompt: Given two sorted integer arrays nums1 and nums2,
 * merge nums2 into nums1 as one sorted array.
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; ++i)
        {
            int j = m + n - 1;
            for (j = m + i - 1; j >= i; --j)
            {
                if (nums1[j] > nums2[i])
                    nums1[j + 1] = nums1[j];
                else
                    break;
            }
            nums1[j + 1] = nums2[i];
                
        }
    }
}

/**
 * Notes: Loop through the second array and for each element, 
 * find a place to insert in the first array, when searching
 * move back those elements that are larger than this element. 
 */