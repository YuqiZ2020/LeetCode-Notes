/**
 * Problem 212: Word Search II
 * Prompt: Given a 2D board and a list of words from the dictionary, 
 * find all words in the board.
 * Each word must be constructed from letters of sequentially 
 * adjacent cell, where "adjacent" cells are those horizontally or 
 * vertically neighboring. The same letter cell may not be used more 
 * than once in a word.
 * Date: 07/04/2020
 */
class Solution {
    class TrieNode
    {
        public String word;
        public TrieNode[] children = new TrieNode[26];
        TrieNode()
        {
            word = "";
        }
        public void insert(String word)
        {
            TrieNode cur = this;
            for (int i = 0; i < word.length(); ++i)
            {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
    }
    public TrieNode BuildTrie(String[] words)
    {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; ++i)
            root.insert(words[i]);
        return root;
    }
    public void dfs(char[][] board, int r, int c, TrieNode root, List<String> ans)
    {
        char ch = board[r][c];
        if (ch == '@')
            return;
        TrieNode next = root.children[ch - 'a'];
        if (next != null)
        {
            if (next.word != "")
            {
                ans.add(next.word);
                next.word = "";
            }
            board[r][c] = '@';
            if (r > 0) 
                dfs(board, r - 1, c, next, ans);
            if (r < board.length - 1)
                dfs(board, r + 1, c, next, ans);
            if (c < board[0].length - 1)
                dfs(board, r, c + 1, next, ans);
            if (c > 0)
                dfs(board, r, c - 1, next, ans);
            board[r][c] = ch;
        }
    }
    public List<String> findWords(char[][] board, String[] words) 
    {
        TrieNode root = BuildTrie(words);
        List <String> answer = new ArrayList<>();
        for (int i = 0; i < board.length; ++i)
        {
            for (int j = 0; j < board[0].length; ++j)
            {
                dfs(board, i, j, root, answer);
            }
        }
        return answer;
    }
}

/**
 * Notes: Build a Trie to save the word list and use dfs to search
 * for the words on the board with various starting points. 
 * The Trie only has to contain the children field and we can store
 * the string of the compelete word in the end of each word, because
 * we would always need to have the word string when saving. 
 * when doing the dfs search we need to avoid using the same number 
 * again for one search, so we need to change the character 
 * of the number when we start the search and change it back when
 * we get back. 
 */