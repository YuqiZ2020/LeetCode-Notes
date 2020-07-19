/**
 * Problem 151: Reverse Words in a String
 * Prompt: Given an input string, reverse the string word by word.
 */
class Solution {
    public String reverseWords(String s) {
        String[] sArray = s.split("\\s{1,}");
        if (sArray.length < 1)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = sArray.length - 1; i > 0; --i)
        {
            sb.append(sArray[i]);
            sb.append(' ');
        }
        sb.append(sArray[0]);

        return sb.toString().trim();
    }
}

/**
 * Notes: Use the special split function to allow the ignorance 
 * of multiple white spaces. Finally use trim() to trim off
 * the trailing spaces in the end. 
 */