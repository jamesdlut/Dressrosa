/*
Excel Sheet Column Title
Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/
/*
Excel序是这样的: A~Z, AA~ZZ, AAA~ZZZ, ...
本质上就是将一个10进制数转换为一个26进制数
note:
28 
append 'A' + 27 % 26 = 'B' -> 0 B
append 'A' -> 0 B 1 A, that is, BA
*/
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if (n < 1) {
            return "";
        } else {
            while (n > 0) {
                n--;
                char c = (char) (n % 26 + 'A');
                sb.append(c);
                n /= 26;
            }
            return sb.reverse().toString();
        }
    }
}
