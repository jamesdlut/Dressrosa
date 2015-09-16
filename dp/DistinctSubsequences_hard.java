/*
by yiming
Distinct Subsequences
Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.
*/
/*
在S中找T包含的所有字符（要按T的顺序），一共有几种组合？
S = "rabbbit" T = "rabbit"
rab1b2it
rab1b3it
rab2b3it
  01234567
   rabbbit
0 11111111
1r01111111
2a00111111
3b00012333 
4b00001333
5i00000033
6t00000003
i = 0 j = 0 num[0][0] = 1 
i = 1 j = 0 num[1][0] = 1 j = 1 S.charAt(1 - 1) == T.charAt(1 - 1) num[1][1] = 0 + num[0][0] = 1 j = 2 num[1][2] = 0 + num[0][2] = 0 ... 
i = 2 j = 0 num[2][0] = 1 j = 1 num[2][1] += num[1][1] = 1 j = 2 num[2][2] += num[1][1] = 1 j = 3 num[2][3] += num[2][2] = 1
i = 3 j = 0 num[3][0] = 1 j = 1 num[3][1] += num[2][1] = 1 j = 2 num[3][2] += num[2][2] = 1 j = 3 num[3][3] += num[2][2] = 1 j = 4 num[3][4] += num[2][4] = 0
i = 4 j = 0 num[4][0] = 1 j = 1 num[4][1] += num[3][1] = 1 j = 2 num[4][2] += num[3][2] = 1 num[4][3] += num[3][2] = 1, num[4][3] += num[3][3] = 2 num[4][4] += num[3][3] = 1 num[4][5] += num[3][5] = 0
*/ 
public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }
        if (S.length() < T.length()) {
            return 0;
        }
        
        int[][] num = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); i++) {
            for (int j = 0; j <= T.length(); j++) {
                if (i == 0 && j == 0) {
                    num[i][j] = 1;
                } else if (i == 0) {
                    num[i][j] = 0;
                } else if (j == 0) {
                    num[i][j] = 1;
                } else {
                    num[i][j] = 0;
                    if (S.charAt(i - 1) == T.charAt(j - 1)) {
                        num[i][j] += num[i - 1][j - 1];
                    }
                    num[i][j] += num[i - 1][j];
                }
                
            }
        }
        return num[S.length()][T.length()];
    }
}
