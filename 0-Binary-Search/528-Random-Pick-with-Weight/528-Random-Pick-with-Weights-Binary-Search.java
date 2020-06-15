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
        return binarySearch(weightedSum, rand);
    }
    
    private int binarySearch(int[] wS, int r)
    {
        int high = wS.length;
        int low = 0;
        int mid = 0;
        while (low < high)
        {
            mid = low + (high - low) / 2;
            if (wS[mid] < r)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

/**
 * Notes: Same for maintaining a cumulative sum, but uses binary search
 * to find the corresponding index. 
 */