class Solution {
    public String longestDupSubstring(String S) {
        int low = 0;
        int high = S.length();
        String ans = "";
        int p = 19260817;
        int[] power = new int[high];
        power[0] = 1;
        for (int i = 1 ; i < high; i++)
            power[i] = (power[i - 1] * 26) % p;
        while (low < high)
        {
            int mid = low + (high - low) / 2;
            String temp = search(S, mid, power);
            if (temp != "")
            {
                low = mid + 1;
                ans = temp;
            }
            else
                high = mid;
        }
        return ans;
    }
    
    private String search(String str, int len, int[] power)
    {
        if (len == 0)
            return "";
        int p = 19260817;
        int hashVal = 0;
        for (int i = 0 ; i < len; i++) 
            hashVal = ((hashVal * 26) % p + (str.charAt(i) - 'a')) % p;
        
        HashMap<Integer, List<Integer>> allVal = new HashMap<>();
        allVal.put(hashVal, new ArrayList<>(Arrays. asList(0)));
        
        for (int i = 1; i < str.length() - len + 1; ++i)
        {
            hashVal = ((hashVal - power[len - 1] * (str.charAt(i - 1) - 'a')) % p + p) % p;
            hashVal = ((hashVal * 26) % p + (str.charAt(i + len - 1) - 'a')) % p;
            
            if (!allVal.containsKey(hashVal))
                allVal.put(hashVal, new ArrayList<>(Arrays. asList(i)));
            else
            {
                String temp = str.substring(i, i + len);
                for (int j : allVal.get(hashVal))
                {
                    if (temp.equals(str.substring(j, j + len)))
                        return temp;
                }
                List<Integer> newList = allVal.get(hashVal);
                newList.add(i);
                allVal.replace(hashVal, newList);
            }
        }
        return "";
    }
}

/**
 * Notes: Use a hash function to compute a value for each string pattern
 * and when meeting the same value compare character by character. 
 */