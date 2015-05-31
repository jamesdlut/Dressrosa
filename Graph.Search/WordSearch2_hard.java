/*
Word Search II 
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
For example,
Given words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.
You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
*/
public class WordSearch2Sol {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new ArrayList<String>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root == null) {
                    return rst;
                }
                search(board, i, j, rst, visit, trie.root, trie);
            }
        }
        return rst;
    }
    
    private static void search(char[][] board, int i, int j, List<String> rst, boolean[][] visit, TrieNode node, Trie trie) {
        if (node == null) {
            return;
        }
        int c = board[i][j] - 'a';
        TrieNode nextNode = node.children[c];
        if (nextNode == null) {
            return;
        }
        if (nextNode.have) {
            rst.add(nextNode.word);
            trie.remove(nextNode.word);
        }
        int row = board.length;
        int col = board[0].length;
        visit[i][j] = true;
        if (i + 1 < row && !visit[i + 1][j]) {
            search(board, i + 1, j, rst, visit, nextNode, trie);
        }
        if (i - 1 >= 0 && !visit[i - 1][j]) {
            search(board, i - 1, j, rst, visit, nextNode, trie);
        }
        if (j + 1 < col && !visit[i][j + 1]) {
            search(board, i, j + 1, rst, visit, nextNode, trie);
        }
        if (j - 1 >= 0 && !visit[i][j - 1]) {
            search(board, i, j - 1, rst, visit, nextNode, trie);
        }
        visit[i][j] = false;
    }
    
    public static class TrieNode {
        boolean have;
        TrieNode[] children;
        String word;
        public TrieNode() {
            have = false;
            children = new TrieNode[26];
        }
    }
    
    public static class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode cur = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            cur.have = true;
            cur.word = word;
        }
        
        public void remove(String word) {
            TrieNode cur = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int c = word.charAt(i) - 'a';
                TrieNode parent = cur;
                cur = cur.children[c];
            }
            cur.have = false;
            cur.word = null;
        }
    }
    
    public static void main(String[] args) {
    	String[] words = {"oath", "pea", "eat", "rain"};
    	char[][] board = {
    			          {'o','a','a','n'},
    			          {'e','t','a','e'},
    			          {'i','h','k','r'},
    			          {'i','f','l','v'}
    	                  };
    	System.out.print(findWords(board, words));
    }
}
