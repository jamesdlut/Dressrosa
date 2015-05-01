/*
by yiming
Palindrome Partitioning II
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        boolean[][] isPalindromeArray2 = getIsPalindrome(s); 
        // boolean[][] isPalindromeArray2 = new boolean[s.length()][s.length()];
        // isPalindromeArray2 = getIsPalindrome(s);
        
        int[] min = new int[s.length() + 1];
        min[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            min[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (isPalindromeArray2[i - j][i - 1] && min[i - j] != Integer.MAX_VALUE) {
                    min[i] = Math.min(min[i], min[i - j] + 1); 
                    // c|abba| actual cut is 1, thus return minus 1 later
                }
            }
        }
        return min[s.length()] - 1;
    }
/*    
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j++) { 
        // for (int i, int j; i < j; i++, j--) { // error: <identifier> expected
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            // bug: return true;
        }
        return true;
    }
*/    
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindromeArray = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindromeArray[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindromeArray[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int len = 2; len < s.length(); len++) {
            for (int start = 0; start + len < s.length(); start++) {
                isPalindromeArray[start][start + len] = isPalindromeArray[start + 1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
            }
        }
        return isPalindromeArray;
    }
}
