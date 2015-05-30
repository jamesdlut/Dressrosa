/*
N-Queens
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Challenge
Can you do it without recursion?
*/
/*
SOL 1
cols: 存放每一行皇后的列值, 我们在每一行放一个皇后
DFS 某一行中所有的位置, 看是否可以放置一个皇后
若加新皇后在row = cols.size() - 1行的下一行的第col列, 则新皇后的行号和列号是:
(cols.size(), col)
但若棋盘上已有的某皇后位置, 比如(i, cols.get(i)), 与新皇后位置互为对角线, 则不可行
*/
public class NQueensSol {
	public static List<String[]> solveNQueens1(int n) {
		List<String[]> rst = new ArrayList<String[]>();
		List<Integer> cols = new ArrayList<Integer>();
		if (n <= 0) {
			return rst;
		}
		helper(n, cols, rst);
		return rst;
	}
	
	public static String[] createSol(int n, List<Integer> cols) {
		String[] chessboard = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (j == cols.get(i)) {
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			chessboard[i] = sb.toString();
		}
		return chessboard;
	}
	
	private static boolean isValid(List<Integer> cols, int col) {
		for (int i = 0; i < cols.size(); i++) {
			if (col == cols.get(i)) {
				return false;
			}
			if (cols.size() - i == Math.abs(col - cols.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	private static void helper(int n, List<Integer> cols, List<String[]> rst) {
		if (cols.size() == n) {
			rst.add(createSol(n, new ArrayList<Integer>(cols)));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (!isValid(cols, col)) {
				continue;
			}
			cols.add(col);
			helper(n, cols, rst);
			cols.remove(cols.size() - 1);
		}
	}

	public static List<String[]> solveNQueens2(int n) {
		List<String[]> ret = new ArrayList<String[]>();
		if (n == 0) {
			return ret;
		}
		StringBuilder[] list = new StringBuilder[n];
		for (int i = 0; i < n; i++) {
			list[i] = new StringBuilder();
			for (int j = 0; j < n; j++) {
				list[i].append('.');
			}
		}
		dfs(n, list, ret, 0);
		return ret;
	}
	
	public static void dfs(int n, StringBuilder[] list, List<String[]> ret, int index) {
		int rows = list.length;
		if (n == 0) {
			String[] strs = new String[rows];
			for (int i = 0; i < rows; i++) {
				strs[i] = list[i].toString();
			}
			ret.add(strs);
			return;
		}
		if (index >= rows * rows) {
			return;
		}
		for (int i = index; i < rows * rows; i++) {
			int row = i / rows;
			int col = i % rows;
			if (!canPut(list, row, col)) {
				continue;
			}
			list[row].setCharAt(col, 'Q');
			dfs(n - 1, list, ret, i + 1);
			list[row].setCharAt(col, '.');
		}
		return;
	}
	
	public static boolean canPut(StringBuilder[] list, int row, int col) {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				if (list[i].charAt(j) == 'Q' &&
						(i == row || j == col || Math.abs(i - row) == Math.abs(j - col))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<String[]> list = solveNQueens2(4);
		for (String[] str : list) {
			for (String s : str) {
				System.out.println(s);
			}
			System.out.print("\n");
		}
	}
}
