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