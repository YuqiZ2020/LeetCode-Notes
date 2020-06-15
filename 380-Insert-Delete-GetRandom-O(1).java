/**
 * Problem 380: Insert Delete GetRandom O(1)
 * Prompt: Design a data structure that supports all 
 * following operations in average O(1) time.
 * 1. insert(val): Inserts an item val to the set if not already present.
 * 2. remove(val): Removes an item val from the set if present.
 * 3. getRandom: Returns a random element from current set of elements. 
 * Each element must have the same probability of being returned.
 * Date:06/12/2020
 */
class RandomizedSet {
    int len;
    HashMap<Integer, Integer> mMap = new HashMap<>();
    List<Integer> mList = new ArrayList<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        len = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (mMap.containsKey(val) == false)
        {
            mMap.put(val, len);
            mList.add(val);
            len++;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (mMap.containsKey(val) == true)
        {
            int t = mMap.get(val);
            mMap.remove(val);
            if (t < len - 1)
            {
                int lastVal = mList.get(len - 1);
                mList.set(t, lastVal);
                mMap.replace(lastVal, t);
            }
            mList.remove(len - 1);
            len--;
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random ran = new Random(); 
        int idx = ran.nextInt(len);
        return mList.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

 
/**
 * Notes: Use an array list to store the numbers and use
 * a hashmap to store the index of the number. When removing element
 * need to first switch the element with the last one before 
 * removing, otherwise the sequences will be changed. 
 */