/*
by yiming
Edit Distance
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
*/
/*
note: two sequence dp different with matrix dp
*/
/*
定义D[i][j] 为string1 前i个字符串到 string2的前j个字符串的转化的最小步。
1. 初始化： D[0][0] = 0;  2个为空 不需要转
2. D[i][0] = D[i - 1][0] + 1. 就是需要多删除1个字符
3. D[0][j] = D[0][j - 1] + 1. 就是转完后需要添加1个字符
a、给word1插入一个和word2最后的字母相同的字母，这时word1和word2的最后一个字母就一样了，此时编辑距离等于1（插入操作） + 插入前的word1到word2去掉最后一个字母后的编辑距离
D[i][j - 1] + 1
例子：  从ab --> cd
我们可以计算从 ab --> c 的距离，也就是 D[i][j - 1]，最后再在尾部加上d
b、删除word1的最后一个字母，此时编辑距离等于1（删除操作） + word1去掉最后一个字母到word2的编辑距离
D[i - 1][j] + 1
例子：  从ab --> cd
我们计算从 a --> cd 的距离，再删除b, 也就是 D[i - 1][j] + 1
c 、把word1的最后一个字母替换成word2的最后一个字母，此时编辑距离等于 1（替换操作） + word1和word2去掉最后一个字母的编辑距离。
这里有2种情况，如果最后一个字符是相同的，即是：D[i - 1][j - 1]，因为根本不需要替换，否则需要替换，就是
D[i - 1][j - 1] + 1
然后取三种情况下的最小距离
基于证明，当最后一个字符相同时，我们其实可以直接让D[i][j] = D[i - 1][j - 1].
*/
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] min = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    min[i][j] = j;
                } else if (j == 0) {
                    min[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        //min[i][j] = Math.min(min[i][j - 1], min[i - 1][j]);
                        min[i][j] = Math.min(min[i - 1][j - 1], min[i][j - 1]);
                        min[i][j] = Math.min(min[i][j], min[i - 1][j]);
                        min[i][j]++;
                    } else {
                        min[i][j] = min[i - 1][j - 1];
                    }
                }
            }
        }
        return min[len1][len2];
    }
}
