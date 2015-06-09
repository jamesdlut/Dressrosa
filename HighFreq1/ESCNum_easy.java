/*
Excel Sheet Column Number 
Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/
/*
26进制转10进制, 注意以'A'而不是0开头, 因此要“+1”
e.g. 
Input: "BA"
Output:	27
i 0 
num = 0 * 26 + 'B' - 'A' + 1 = 2
i 1
num = 1 * 26 + 'A' - 'A' + 1 = 27
*/
public class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 26 + (s.charAt(i) - 'A' + 1);
        }
        return num;
    }
}
