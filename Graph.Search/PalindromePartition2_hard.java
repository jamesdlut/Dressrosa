/*
Palindrome Partitioning II
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
/*
使用DP来解决:
1. D[i]表示前i个字符切为回文需要的切割数
2. P[i][j]: S.sub(i-j) is a palindrome.
3. 递推公式: D[i] = Math.min(D[i], D[j] + 1), 0 <= j <= i - 1), 并且要判断P[j][i - 1]是不是回文.
4. 注意D[0] = -1的用意, 它是指当整个字符串判断出是回文是, 因为会D[0] + 1其实应该是结果为0 (没有任何切割), 所以, 应把D[0]设置为-1
有个转移函数之后, 一个问题出现了, 就是如何判断[i,j]是否是回文? 每次都从i到j比较一遍? 太浪费了, 这里也是一个DP问题.
定义函数
P[i][j] = true if [i, j]为回文
那么
P[i][j] = str[i] == str[j] && P[i + 1][j - 1].
The worst case is cut character one by one.
*/
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] D = new int[len + 1];
        D[0] = -1;
        boolean[][] P = new boolean[len][len];
        
        for (int i = 1; i <= len; i++) {
            D[i] = i - 1;
            for (int j = 0; j <= i - 1; j++) {
                P[j][i - 1] = false;
                if (s.charAt(j) == s.charAt(i - 1) && (i - 1 - j <= 2 || P[j + 1][i - 2])) {
                    P[j][i - 1] = true;
                    D[i] = Math.min(D[i], D[j] + 1);
                }
            }
        }
        return D[len];
    }
}
