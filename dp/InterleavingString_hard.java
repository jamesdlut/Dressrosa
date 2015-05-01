/*
by yimingumass
Interleaving String
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2. For example,
Given:
s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
/*
solution 1: Recursion with memory
*/
public class Solution {
    public static boolean isInterleave1(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        // The length is not equal, just return false.
        if (len1 + len2 != len3) {
            return false;
        }

        int[][][] memory = new int[len1 + 1][len2 + 1][len3 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                for (int k = 0; k <= len3; k++) {
                    memory[i][j][k] = -1;
                }
            }
        }

        return recMemory(s1, 0, s2, 0, s3, 0, memory);
    }

    public static boolean recMemory(String s1, int index1, String s2,
            int index2, String s3, int index3, int[][][] memory) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (index3 == len3 && index1 == len1 && index2 == len2) {
            return true;
        }

        if (memory[index1][index2][index3] != -1) {
            return memory[index1][index2][index3] == 1;
        }

        // 第一个字符，有2种可能：来自s1, 或是来自s2
        boolean ret = false;
        if (index1 < len1 && s1.charAt(index1) == s3.charAt(index3)) {
            ret = recMemory(s1, index1 + 1, s2, index2, s3, index3 + 1, memory);
        }

        // 如果不成功(首字母不来自于s1)，尝试另一种可能
        if (!ret && index2 < len2 && s2.charAt(index2) == s3.charAt(index3)) {
            ret = recMemory(s1, index1, s2, index2 + 1, s3, index3 + 1, memory);
        }

        memory[index1][index2][index3] = ret ? 1 : 0;
        return ret;
    }
}
/*
solution 2: dp
*/
/*
D[i][j]: 定义为s1 (前i个字符) s2(前j个字符) s3(i+j 个字符) 是不是交叉字符
递推公式： (s1.i == s3.(i+j) && D[i-1][j]) || (s2.j == s3.(i+j) && D[i][j - 1])
分别从s1,s2两种可能性来匹配 ，两者有一个成立就行了。
s1 s3 首字母相同，继续查i -1 与 i + j -1 是否isInterleave1
s2 s3 首字母相同，继续查j -1 与 i + j -1 是否isInterleave1
初始化：D 0,0 就是true，因为都是空.
D[0][j] 就是判断一下str2与str3是不是尾字符相同，及D[0][j - 1]是不是true
D[i][0] 就是判断一下str1与str3是不是尾字符相同，及D[i - 1][0]是不是true
*/
/*
s1 = "aabcc",
s2 = "dbbca",
s3 = "aadbbcbcac", 
i = 1 j = 1 s3.charAt(1) == s1.charAt(0), interleaved[0][1] s3.charAt(1) != s2.charAt(0), interleaved[1][0] -> interleaved[1][1] = true
*/
/*
time O(N^2)
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean[][] interleaved = new boolean[s1.length() + 1][s2.length()];
        interleaved[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0]) {
                interleaved[i][0] = true;
            }
        }
        for (int j = 1; j <= s2.length(); j++) {
            if (s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1]) {
                interleaved[0][j] = true;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j<= s2.length(); j++) {
                if (((s3.charAt(i + j - 1) == s1.charAt(i - 1)) && interleaved[i - 1][j]) || ((s3.charAt(i + j - 1) == s2.charAt(j - 1)) && interleaved[i][j - 1])) {
                    interleaved[i][j] = true;
                }                                                    
            }
        }
        return interleaved[s1.length()][s2.length()];
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if (len1 + len2 != len3) {
            return false;
        }
        
        boolean[][] D = new boolean[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                D[i][j] = false;
                if (i == 0 && j == 0) {
                    D[i][j] = true;
                    continue;
                }
                
                if (i != 0) {
                    D[i][j] |= s1.charAt(i - 1) == s3.charAt(i + j - 1) && D[i - 1][j];
                }
                
                if (j != 0) {
                    D[i][j] |= s2.charAt(j - 1) == s3.charAt(i + j - 1) && D[i][j - 1];
                }
            }
        }
        
        return D[len1][len2];
    }
}
