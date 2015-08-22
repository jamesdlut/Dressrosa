/*
by yiming
Reverse Words in a String
Given an input string, reverse the string word by word.
For example,
Given s = "the sky is blue",
return "blue is sky the".
*/
/*
Class String
.trim(): Returns a string whose value is this string, with any leading and trailing whitespace removed.
.split(String regex): Splits this string around matches of the given regular expression. Return String[]
Regular Expression
\\s+: 第一个"\"是用来转义的, "\s+"正则表达式表示至少出现一个空格
*/
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        String sTrim = s.trim();
        String[] str = sTrim.split("\\s+");
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    /*
    public static void main {
        reverseWords("I love umass");
    }
    */
}
