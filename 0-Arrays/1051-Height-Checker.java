/**
 * Problem 1051: Height Checker
 * Prompt: Students are asked to stand in non-decreasing 
 * order of heights for an annual photo.
 * Return the minimum number of students that must move in
 * order for all students to be standing in non-decreasing 
 * order of height.
 * Notice that when a group of students is selected they 
 * can reorder in any possible way between themselves and 
 * the non selected students remain on their seats.
 * Date: 05/21/2020
 */
class Solution {
    public int heightChecker(int[] heights) {
        int[] sorted = new int[heights.length];
        for (int i = 0; i < heights.length; ++i)
            sorted[i] = heights[i];
        Arrays.sort(sorted);
        int ans = 0;
        for (int i = 0; i < heights.length; ++i)
        {
            if (heights[i] != sorted[i])
                ans++;
        }
        return ans;
    }
}

/**
 * Notes: This problem is worded wierdly. 
 * It simply wants you to check how many elements
 * are out of place. 
 */