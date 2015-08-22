/*
N-Queens II
Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.
*/
/*
The base case: 当最后一行, 皇后只有1种放法(就是不放)
当row == size时, 也就是row越界了, 这时意思是整个N-Queen都摆满了, 我们这时应返回解为1. 因为
你不需要任何动作, 也就是唯一的解是保持原状.
*/
public class Solution {
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        
        return dfs(n, 0, new ArrayList<Integer>());
    }
    
    public int dfs(int n, int row, ArrayList<Integer> path) {
        if (row == n) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!isValid(path, i)) {
                continue;
            }
            path.add(i);
            cnt += dfs(n, row + 1, path);
            path.remove(path.size() - 1);
        }
        return cnt;
    }
    
    public boolean isValid(ArrayList<Integer> path, int col) {
        int size = path.size();
        for (int i = 0; i < size; i++) {
            if (col == path.get(i)) {
                return false;
            }
            if (size - i == Math.abs(col - path.get(i))) {
                return false;
            }
        }
        return true;
    }
}
