/**
 * Problem 1482: Minimum Number of Days to Make m Bouquets
 * Prompt: Given an integer array bloomDay, an integer m and an integer k.
 * We need to make m bouquets. To make a bouquet, you need to use k 
 * adjacent flowers from the garden.
 * The garden consists of n flowers, the ith flower will bloom in the 
 * bloomDay[i] and then can be used in exactly one bouquet.
 * Return the minimum number of days you need to wait to be able to make m 
 * bouquets from the garden. If it is impossible to make m bouquets 
 * return -1.
 * Date: 07/07/2020
 */
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 1; int right = 1000000000;
        int len = bloomDay.length; 
        if (len < m * k) return -1;
        while (left < right)
        {
            int mid = left + (right - left) / 2;
            int count = 0;
            int bouq = 0;
            for (int i = 0; i < len; ++i)
            {
                if (bloomDay[i] <= mid)
                    count++;
                else
                {
                    bouq += (count / k);
                    count = 0;
                }
            }
            bouq += (count / k);
            if (bouq < m)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

/**
 * Notes: Use binary search to find the best date. For each given date
 * we can calculate out how many bouque we can make by finding concecutive
 * flowers that bloomed and produce the caluclation. Then if we don't have
 * enough flowers we can go to the right interval or got to the left interval
 * for the other way around. 
 */