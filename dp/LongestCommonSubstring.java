/*
by yiming
Longest Common Substring
Given two strings, find the longest common substring.
Return the length of it.
Note
The characters in substring should occur continiously in original string. This is different with subsequence.
Example
Given A=“ABCD”, B=“CBCE”, return 2
*/
public class Solution {
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null) { // if (A.length() == 0 || B.length() == 0) 
            return 0;
        }
        
        int len = 0;
        int[][] sameCount = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                if (i == 0 || j == 0) {
                    sameCount[i][j] = 0;
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        sameCount[i][j] = sameCount[i - 1][j - 1] + 1;
                    } else {
                        sameCount[i][j] = 0;
                    }
                }
                len = Math.max(sameCount[i][j], len);
            }
        }
        return len;
    }
}
