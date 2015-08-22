/*
Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
1 o_o 2 abc 3 def
4 ghi 5 jkl 6 mno
7 pqrs 8 tuv 9 wxyz
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
public class Solution {
    // SOL 1 DFS Backtracking
    public List<String> letterCombinations1(String digits) {
        List<String> rst = new ArrayList<String>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() != 0) {
            dfs1(digits, new StringBuilder(), rst, map, 0);
        }
        return rst;
    }
    
    public void dfs1(String digits, StringBuilder sb, List<String> rst, String[] map, int index) {
        int len = digits.length();
        if (index == len) {
            rst.add(sb.toString());
            return;
        }
        String s = map[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs1(digits, sb, rst, map, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public List<String> letterCombinations2(String digits) {
        List<String> rst = new ArrayList<String>();
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        StringBuilder sb = new StringBuilder();
        if (digits.length() != 0) {
            dfs2(map, digits, sb, rst, 0);
        }
        return rst;
    }
    
    private void dfs2(Map<Character, char[]> map, String digits, StringBuilder sb, List<String> rst, int index) {
        int len = digits.length();
        if (index == len) {
            rst.add(sb.toString());
            return;
        }
        char[] s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
            dfs2(map, digits, sb, rst, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
