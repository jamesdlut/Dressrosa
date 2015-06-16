/*
6 ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
/*
两个规律:
1 两个zigzag之间间距为 2 * numRows - 2
2 每个zigzag中间(在j和j + interval之间)位置为 j + interval - 2 * i
注意: 当Rows = 1时, 此方法不适用, 因为size = 0, 会造成死循环. 所以Rows = 1时, 需要独立处理
*/
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null) {
            return null;
        }
        
        if (numRows == 1) {
            return s;
        }
        
        int interval = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += interval) {
                char c = s.charAt(j);
                sb.append(c);
                int mid = j + interval - 2 * i;
                if (i != 0 && i != numRows - 1 && mid < len) {
                    sb.append(s.charAt(mid));
                }
            }
        }
        return sb.toString();
    }
}
