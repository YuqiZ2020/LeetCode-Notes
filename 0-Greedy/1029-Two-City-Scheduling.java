/**
 * Problem 1029: Two City Scheduling
 * Prompt: There are 2N people a company is planning 
 * to interview. The cost of flying the i-th person to 
 * city A is costs[i][0], and the cost of flying the 
 * i-th person to city B is costs[i][1].
 * Return the minimum cost to fly every person to a 
 * city such that exactly N people arrive in each city.
 * Date: 06/03/2020
 */

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        int costsA = 0;
        int[] costsToB = new int[len];
        for (int i = 0; i < len; ++i)
        {
            costsA += costs[i][0];
            costsToB[i] = -costs[i][0] + costs[i][1];
        }
        Arrays.sort(costsToB);
        int ans = costsA;
        for (int i = 0; i < len / 2; ++i)
            ans += costsToB[i];
        return ans;
    }
}

/**
 * Notes: First pretend that we are sending everyone to city A
 * Then calculate the overall cost. Then we calculate how much
 * we will spend if we alter that person to city B. This is 
 * the cost to city B subtract the cost to city A. 
 */