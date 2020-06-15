/**
 * Problem 528: Random Pick with Weight
 * Prompt: Given an array w of positive integers, where w[i] 
 * describes the weight of index i, write a function pickIndex
 * which randomly picks an index in proportion to its weight.
 * For example, given an input list of values [1, 9], when we
 * pick up a number out of it, the chance is that 9 times out
 * of 10 we should pick the number 9 as the answer.
 */
class Solution {
    private int len;
    private int[] weightedSum;
    private Random random = new Random();
    
    public Solution(int[] w) 
    {
        len = w.length;
        weightedSum = new int[len];
        weightedSum[0] = w[0];
        for (int i = 1; i < len; ++i)
            weightedSum[i] = weightedSum[i - 1] + w[i];
    }
    
    public int pickIndex() {
        int rand = random.nextInt(weightedSum[len - 1]) + 1;
        System.out.println(rand);
        int i = 0;
        while (rand > weightedSum[i])
            i++;
        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

/**
 * Notes: Maintain a cumulative sum for the whole array, then pick a 
 * random integer starting from 1 to the highest cumulative sum, inclusively. 
 * Then see which range this random number fall into and pick the
 * corresponding index. 
 */