/**
 * Problem 1503: Last Moment Before All Ants Fall Out of a Plank
 * Prompt: We have a wooden plank of the length n units. Some ants 
 * are walking on the plank, each ant moves with speed 1 unit per 
 * second. Some of the ants move to the left, the other move to 
 * the right.
 * When two ants moving in two different directions meet at some 
 * point, they change their directions and continue moving again. 
 * Assume changing directions doesn't take any additional time.
 * When an ant reaches one end of the plank at a time t, it falls 
 * out of the plank imediately.
 * Given an integer n and two integer arrays left and right, the 
 * positions of the ants moving to the left and the right. Return 
 * the moment when the last ant(s) fall out of the plank.
 * Date: 07/04/2020
 */
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) 
    {
        int maxL = 0;
        int minR = n + 1;
        for (int i = 0; i < left.length; ++i)
        {
            if (left[i] > maxL)
                maxL = left[i];
        }
        for (int i = 0; i < right.length; ++i)
        {
            if (right[i] < minR)
                minR = right[i];
        }
        return Math.max(maxL, n - minR);
    }
}

/**
 * Notes: ANts changed direction but are actually the same
 * condition as before. 
 */