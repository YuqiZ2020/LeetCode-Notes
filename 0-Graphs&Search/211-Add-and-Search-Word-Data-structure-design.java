class WordDictionary {
    
    public boolean isWord = false; 
    public WordDictionary[] children = new WordDictionary[26];
    
    /** Initialize your data structure here. */
    public WordDictionary() {
    }
    
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary cur = this;
        for (int i = 0; i < word.length(); ++i)
        {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null)
            {
                cur.children[c - 'a'] = new WordDictionary();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        WordDictionary cur = this; 
        for (int i = 0; i < word.length(); ++i)
        {
            char c = word.charAt(i);
            if (c == '.')
            {
                for (int j = 0; j < 26; ++j)
                {
                    if (cur.children[j] != null)
                    {
                        if (cur.children[j].search(word.substring(i + 1)))
                            return true;
                    }
                }
                return false;
            }
            if (cur.children[c - 'a'] == null) 
                return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/**
 * Notes: The design is the same as Trie. We only need a boolean
 * for whether this is a word and the length 26 array for children. If
 * a letter exists then it automatically has a node in the array. 
 * When searching, when we meet a '.' we can implement a recursive
 * search for all letters and see if any is true. If yes, return true, 
 * otherwise return false. Other searches are the same. 
 */