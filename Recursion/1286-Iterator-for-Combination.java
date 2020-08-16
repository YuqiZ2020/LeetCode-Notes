/**
 * Problem 1286: Iterator for Combination
 * Prompt: Design an Iterator class, which has:
 * A constructor that takes a string characters of sorted 
 * distinct lowercase English letters and a number combination
 * Length as arguments.
 * A function next() that returns the next combination of 
 * length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there 
 * exists a next combination.
 * Date: 08/14/2020
 */
class CombinationIterator {

    int idx = 0;
    int len;
    List<String> combs = new ArrayList<>();
    int combCount;
    public CombinationIterator(String characters, int combinationLength) {
        len = combinationLength;
        char[] ele = characters.toCharArray();
        Arrays.sort(ele);
        preProcess(ele, 0, 0, new StringBuilder());
        combCount = combs.size();
    }
    
    private void preProcess(char[] arr, int st, int curLen, StringBuilder result)
    {
        if (curLen == len)
        {
            combs.add(result.toString());
            return;
        }
        for (int i = st; i <= arr.length - (len - curLen); ++i)
        {
            result.append(arr[i]);
            preProcess(arr, i + 1, curLen + 1, result);
            result.deleteCharAt(curLen);
        }
    }
    
    public String next() {
        return combs.get(idx++);
    }
    
    public boolean hasNext() {
        if (idx == combCount)
            return false;
        return true;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/**
 * Notes: Produce the combinations in an array list and use an index
 * to keep track of which position we are at. 
 * We use a recursive method to generate all the combinations. For each
 * combination, since we go by alphabetical order, if we choose a letter
 * then we can't choose any letters before that. Then we also need to 
 * reserve enought letters for the folllowing choices. 
 * So each time we iterate from starting point to where we would still
 * have enough letters, we add the letter to append to string builder
 * and then recursively call the function. The base case is when 
 * we have enough length of letters.  
 */