/*
by yiming
Longest Common Subsequence
Given two strings, find the longest comment subsequence (LCS). Your code should return the length of LCS. Example For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1 For "ABCD" and "EACB", the LCS is "AC", return 2
*/
/*
sequence is able to jump
*/
public class Solution {
    /**
    * @param A, B: Two strings.
    * @return: The length of longest common subsequence of A and B. 
    */
    public int longestCommonSubsequence(String A, String B) {
        int lena = A.length();
        int lenb = B.length();
        boolean[][] sameCount = new boolean[lena + 1][lenb + 1]; 
        // D[i][j] 定义为s1, s2的前i,j个字符串的最长common subsequence.
        for (int i = 0; i <= lena; i++) {
            for (int j = 0; j <= lenb; j++) {
                if (i == 0 || j == 0) {
                    sameCount[i][j] = 0;
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        sameCount[i][j] = sameCount[i - 1][j - 1] + 1;
                    } else {
                        sameCount[i][j] = Math.max(sameCount[i][j - 1], sameCount[i - 1][j]);
                    }
                }
            }
        }
        return sameCount[A.length][B.length];
    }
}
