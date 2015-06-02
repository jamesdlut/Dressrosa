/*
by yiming
Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/
/*
九章算法的递归模板.
1. Left代表余下的'('的数目
2. right代表余下的')'的数目
3. 注意right余下的数目要大于left, 否则就是非法的, 比如, 先放一个')'就是非法的.
4. 任何一个小于0, 也是错的.
5. 递归的时候, 我们只有2种选择, 就是选择'('还是选择')'
6. 递归的时候, 一旦在结果的路径上尝试过'('还是选择')', 都需要回溯, 即是sb.deleteCharAt(sb.length() - 1);
*/
/*
left: the left Parentheses
right: the right Parentheses
left < right means that we have more ( then we can add ).
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
        if (n == 0) {
            return rst;
        }
        
        dfs(n, n, new StringBuilder(), rst);
        return rst;
    }
    
    public void dfs(int left, int right, StringBuilder sb, List<String> rst) {
        if (left == 0 && right == 0) {
            rst.add(sb.toString());
            return;
        }
        
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        
        dfs(left - 1, right, sb.append('('), rst);
        sb.deleteCharAt(sb.length() - 1);
        dfs(left, right - 1, sb.append(')'), rst);
        sb.deleteCharAt(sb.length() - 1);
    }
}
