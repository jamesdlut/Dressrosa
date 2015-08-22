/*
Combination Sum II
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
/*
每次只取第一个, 例如123334, 到了333这里, 我们第一次只取第1个3, 因为我们选任何一个3是对组合来说是一个解. 所以只第一次取就好了.
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return rst;
        }
        Arrays.sort(candidates);
        dfs1(candidates, target, new ArrayList<Integer>(), rst, 0);
        return rst;
    }
    
    public void dfs1(int[] candidates, int target, List<Integer> path, List<List<Integer>> rst, int index) {
        if (target == 0) {
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        int pre = -1;
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if (num == pre) {
                continue;
            }
            pre = num;
            path.add(num);
            dfs1(candidates, target - num, path, rst, i + 1);
            path.remove(path.size() - 1);
        }
    }
    /*
    public void dfs2(int[] candidates, int target, List<Integer> path, List<List<Integer>> rst, int index) {
        if (target == 0) {
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if (i != index && num == candidates[i - 1]) {
                continue;
            }
            path.add(num);
            dfs2(candidates, target - num, path, rst, i + 1);
            path.remove(path.size() - 1);
        }
    }
    */
}
