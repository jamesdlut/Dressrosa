/*
Add and Search Word - Data structure design
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
For example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
*/
/*
字典树 + dfs
*/
public class WordDictSol {
	public static class WordDictionary {
		private TrieNode root;
		
		public WordDictionary() {
			root = new TrieNode();
		}
		// Adds a word into a data structure.
		public void addWord(String word) {
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
		}
		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			TrieNode cur = root;
			int len = word.length();
			return dfs(cur, word, 0, len);
		}
		
		private boolean dfs(TrieNode node, String word, int pos, int len) {
			if (node == null || (pos == len && !node.have)) {
				return false;
			}
			if (pos == len && node.have) {
				return true;
			}
			if (word.charAt(pos) == '.') {
				for (int i = 0; i < 26; i++) {
					boolean tmp = dfs(node.children[i], word, pos + 1, len);
					if (tmp) {
						return tmp;
					}
				}
				return false;
			} else {
				int c = word.charAt(pos) - 'a';
				return dfs(node.children[c], word, pos + 1, len);
			}
		}
		/*
		public boolean search(String word) {
			TrieNode cur = root;
			int len = word.length();
			for (int i = 0; i < len; i++) {
				int c = word.charAt(i) - 'a';
				if (cur.children[c] == null) {
					return false;
				}
				cur = cur.children[c];
			}
			return cur.have;
		}
		*/
	}
	
	public static class TrieNode {
		boolean have;
		TrieNode[] children;
		public TrieNode() {
			have = false;
			children = new TrieNode[26];
		}
	}
	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("word");
		System.out.print(wordDictionary.search("pattern"));
	}
}
