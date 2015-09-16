/*
by yiming
Longest Palindromic Substring
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
/*
状态表达式：D[i][j] 表示i,j这2个索引之间的字符串是不是回文。
递推公式： D[i][j] = if ( char i == char j) && （D[i + 1][j - 1]  ||  j - i <= 2））
(i, j)
推i,j的时候用到了i+1, j-1，其实意思就是在计算i,j时，关于同一个j-1的所有的i必须要计算过。
我们需要的是i+1, j - 1，实际上就是左下角的值。
1. 00
2. 00 01
      11
3. 00 01 02 (-> 11)
      11 12
         22
3. 00 01 02 03 (-> 12)                      
      11 12 13 (-> 22)
         22 23  
            33
只要我们一列一列计算，就能够成功地利用这个动规公式。
注意：一行一行计算就会失败！
所以我们的循环的设计是这样的：
for (int j = 0; j < len; j++) 
  { for (int i = 0; i <= j; i++) {}}
*/
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        
        String ret = null;
        int max = 0;
        boolean[][] D = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                D[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || D[i + 1][j - 1]);
                if (D[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        ret = s.substring(i, j + 1); // substring(i, j) i inclusive j exclusive
                    }
                }
            }
        }
        return ret;
    }
}
