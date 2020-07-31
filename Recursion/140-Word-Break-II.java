/**
 * Problem 140: Word Break II
 * Prompt: Given a non-empty string s and a dictionary wordDict containing
 * a list of non-empty words, add spaces in s to construct a sentence where 
 * each word is a valid dictionary word. Return all such possible sentences.
 * The same word in the dictionary may be reused multiple times in the 
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Date: 07/30/2020
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }

    public List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> record)
    {
        if(record.containsKey(s)) return record.get(s);
        List<String> ans = new ArrayList<String>();
        for(String word: wordDict)
        {
            if(s.startsWith(word)) 
            {
                String next = s.substring(word.length());
                if (next.length() == 0) 
                    ans.add(word);
                else 
                {
                    for(String temp: dfs(next, wordDict, record)) 
                        ans.add(word + " " + temp);
                }
            }
        }
            
    record.put(s, ans);
    return ans;
    }
}

/**
 * Notes: Direct DFS will cause TLE so we just store our results as we go 
 * to avoid TLE. We keep a map that stores each string and its corresponding
 * answer, so when we meet this string again we can directly return the 
 * answer. We go through the wordDict and check if the word is a suffix
 * of s and if so we do dfs for the subsequent string. 
 * Then we concanate the answer to get the result. 
 */