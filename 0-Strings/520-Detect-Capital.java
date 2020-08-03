class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2)
            return true;
        boolean c1 = Character.isUpperCase(word.charAt(0));
        boolean c2 = Character.isUpperCase(word.charAt(1));
        if (c1 && c2)
        {
            for (int i = 2; i < word.length(); ++i)
            {
                if (Character.isLowerCase(word.charAt(i)))
                    return false;
            }
            return true;
        }
        for (int i = 1; i < word.length(); ++i)
        {
            if (Character.isUpperCase(word.charAt(i)))
                return false;
        }
        return true;
    }
}

/**
 * Notes: Use the first two elements to determine the 3 possible
 * cases. First case is that all elements are capatialized. 
 * The second and third case require all elements besides the 0th
 * one to be lower case. 
 */