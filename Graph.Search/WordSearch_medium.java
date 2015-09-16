/*
Word Search
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
For example,
Given board =
[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
/*
SOL 1
recursition and backtracking
m X n is board size, k is word size.
m * n * 4^(k-1) runtime
recuision最深是k层, recursive部分空间复杂度应该是O(k) + O(m * n) (visit array)
SOL 2
在进入DFS后, 把访问过的节点置为'#', 访问完毕之后再置回来即可, 可以省掉O(m * n)的空间复杂度
*/
public class WordSearchSol {
	public static boolean exist1(char[][] board, String word) {
		if (board == null || word == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visit = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs1(board, i, j, word, 0, visit)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean dfs1(char[][] board, int i, int j, String word, int wordIndex, boolean[][] visit) {
		int rows = board.length;
		int cols = board[0].length;
		int len = word.length();
		if (wordIndex >= len) {
			return true;
		}
		if (i < 0 || i >= rows || j < 0 || j >= cols) {
			return false;
		}
		if (word.charAt(wordIndex) != board[i][j]) {
			return false;
		}
		if (visit[i][j] == true) {
			return false;
		}
		visit[i][j] = true;
		if (dfs1(board, i + 1, j, word, wordIndex + 1, visit)) {
			return true;
		}
		if (dfs1(board, i - 1, j, word, wordIndex + 1, visit)) {
			return true;
		}
		if (dfs1(board, i, j - 1, word, wordIndex + 1, visit)) {
			return true;
		}
		if (dfs1(board, i, j + 1, word, wordIndex + 1, visit)) {
			return true;
		}
		visit[i][j] = false;
		return false;
	}
	
	public static boolean exist2(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		int rows = board.length;
		int cols = board[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs2(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean dfs2(char[][] board, String word, int i, int j, int index) {
		int len = word.length();
		if (index >= len) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board.length) {
			return false;
		}
		if (word.charAt(index) != board[i][j]) {
			return false;
		}
		char tmp = board[i][j];
		board[i][j] = '#';
		boolean ret = dfs2(board, word, i + 1, j, index + 1)
				|| dfs2(board, word, i - 1, j, index + 1)
				|| dfs2(board, word, i, j + 1, index + 1)
				|| dfs2(board, word, i, j - 1, index + 1);
		board[i][j] = tmp;
		return ret;
				
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		String word = "ABCB";
		System.out.print(exist2(board, word));
	}
}
