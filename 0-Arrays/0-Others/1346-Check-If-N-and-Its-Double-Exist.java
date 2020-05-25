/**
 * Problem 1346: Check if N and Its Double Exist
 * Prompt: Given an array arr of integers, 
 * check if there exists two integers N and M such 
 * that N is the double of M ( i.e. N = 2 * M).
 * Date: 05/09/2020
 */
class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; ++i)
        {
            if (hm.get(arr[i] * 2) != null)
                return true;
            if (arr[i] % 2 == 0 && hm.get(arr[i] / 2) != null)
                return true;
            else 
                hm.put(arr[i], 1);     
        }
        return false;
    }
}

/**
 * Notes: For each element store that element in a hash map. 
 * Need to check if the half or the double of that element
 * exists in the hashmap. 
 */