class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap= new HashMap<>();
        for (int i = 0; i < arr.length; ++i)
        {
            if (!countMap.containsKey(arr[i]))
                countMap.put(arr[i], 1);
            else
                countMap.replace(arr[i], countMap.get(arr[i]) + 1);
        }
        List<Integer> freq = new ArrayList<>();
        for (int i: countMap.keySet())
            freq.add(countMap.get(i));
        int ans = countMap.size();
        Collections.sort(freq);
        int i = 0;
        while (k > 0 && freq.get(i) <= k)
        {
            k = k - freq.get(i);
            i++;
            ans--;
        }
        return ans;
    }
}
/**
 * Notes: Since we don't need to know what the numbers are, we 
 * can simply sort all the frequency of different numbers and 
 * starting to decrease from the overall unique numbers count
 * to the point we can remove any more. 
 */