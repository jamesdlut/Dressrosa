/*
Combination Sum III 
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
Ensure that numbers within the set are sorted in ascending order.
Example 1:
Input: k = 3, n = 7
Output:
[[1,2,4]]
Example 2:
Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(rst, 1, 0, k, n, path);
        return rst;
    }
    
    private void dfs(List<List<Integer>> rst, int start, int sum, int k, int n, List<Integer> path) {
        if (sum > n || path.size() > k) {
            return;
        }
        if (path.size() == k && sum == n) {
            rst.add(new ArrayList<Integer>(path));
        } else {
            for (int i = start; i <= 9; i++) {
                path.add(i);
                dfs(rst, i + 1, sum + i, k, n, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
