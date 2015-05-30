/*
Shortest Palindrome 
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
For example:
Given "aacecaaa", return "aaacecaaa".
Given "abcd", return "dcbabcd".
*/
/*
O(N^2) runtime (each isPalindrome is O(N), done N times)
substring(int beginIndex)
*/
public class Solution {
	public static String shortestPalindrome(String s) {
        if (isPalindrome(s)) {
            return s;
        } 
        int i = s.length();
        while (i > 0) {
            String sub1 = s.substring(0, i--);
            if (isPalindrome(sub1)) {
                break;
            }
        }
        i++;
        String sub2 = s.substring(i);
        StringBuilder sb = new StringBuilder();
        for (int j = sub2.length() - 1; j >= 0; j--) {
            sb.append(sub2.charAt(j));
        }
        for (int j = 0; j < s.length(); j++) {
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
    
    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String test = "bcba";
    	System.out.print(shortestPalindrome(test));
    }
}
