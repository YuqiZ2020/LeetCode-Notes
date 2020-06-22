class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0 || citations[0] > len)
            return len;
        int low = 0;
        int high = len;
        while (low < high)
        {
            int mid = low + (high - low) / 2;
            if (len - mid == citations[mid])
                return len - mid;
            else if (len - mid > citations[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return len - low;
    }
}

/**
 * Notes: Maintain a left closed right opened interval
 * so any element in the interval is the possible solution. 
 * When left bound meets right bound the number of citations 
 * is the answer. 
 * The number of the citation can be calculated by len - mid, 
 * and the current citation amount can be accessed. Notice
 * that when these two numbers are the same, it is gaurenteed
 * that this number is the answer. Because any number bigger than 
 * that won't have enough papers and any number smaller than that
 * is not the biggest h-index. 
 * Any time the paper count is bigger than citation count, we can 
 * move left bound forward, otherwise just move right bound to mid. 
 */