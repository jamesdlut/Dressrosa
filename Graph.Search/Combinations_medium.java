/*
Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
/*
这是一道典型的模板题. 以下是模板写法.
1. 必须时刻注意, for循环里是i + 1不是index + 1. 我们当前取过后, 应该是处理下一个位置.
2. start应该是从1开始. 这个是这题的特别情况, 一般idnex是0开始.
3. combination的题目, 注意因为没有顺序, 所以为了避免重复的一些解, 我们只考虑递增的解. 
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (k == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }
        dfs(n, k, new ArrayList<Integer>(), rst, 1);
        return rst;
    }
    
    public void dfs(int n, int k, List<Integer> path, List<List<Integer>> rst, int start) {
        if (path.size() == k) {
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, path, rst, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
