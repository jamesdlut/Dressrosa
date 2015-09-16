/*
by yiming
Word Break
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
For example, given
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code".
*/
/*
time O(N*maxLen) space O(N)
*/
/* leetcode "leet" "code" maxLen = 4
           i = 1 can[1] = false
           j = 1 can[1 - 1] = true
           word substring(1 - 1, 1) "l" not
           note: break statement only take you out of the inside for loop
           i = 2 can[2] = false
           j = 1 can[2 - 1] = false 
           j = 2 can[2 - 2] = true substring(2 - 2, 2) "le" not
           i = 3 can[3] = false
           j = 1 can[3 - 1] = false
           j = 2 can[3 - 2] = false
           j = 3 can[3 - 3] = true substring(3 - 3, 3) "lee" not
           i = 4 can[4] = false
           j = 1 can[4 - 1] = false 
           j = 2 can[4 - 2] = false
           j = 3 can[4 - 3] = false
           j = 4 can[4 - 4] = true substring(4 - 4, 4) "leet" can[4] = true
           i = 5 can[5] = false
           j = 1 can[5 - 1] true substring(5 - 1, 5) "c" not
           j = 2 can[5 - 2] false
           j = 3 can[5 - 3] false j = 4 can[5 - 4] false 
           i = 6 can[6] = false
           j = 1 can[6 - 1] = false 
           j = 2 can[6 - 2] = true substring(6 - 2, 6) "co" not
           j = 3 can[6 - 3] = false
           j = 4 can[6 - 4] = false
           i = 7 can[7] = false
           j = 1 can[7 - 1] = false
           j = 2 can[7 - 2] = false
           j = 3 can[7 - 3] = true substring(7 - 3, 7) "cod" not
           j = 4 can[7 - 4] = false
           i = 8 can[8] = false
           j = 1 can[8 - 1] = false j = 2 can[8 - 2] = false j = 3 can[8 - 3] = false
           j = 4 can[8 - 4] = true substring(8 - 4, 8) "code" can[8] = true
        */
        /*
        beginIndex -- the begin index, inclusive.
        endIndex -- the end index, exclusive.
        String str = "Hello";
        String a = str.substring(2, 4);  // a is "ll" (not "llo")
        String b = str.substring(0, 3);  // b is "Hel"
        String c = str.substring(4, 5);  // c is "o" -- the last char
        */
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
           return false;
        }
        
        int maxLen = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1]; // according to the definition of substring
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int j = 1; j <= maxLen && j <= i; j++) {
                if (!canSegment[i - j]) {
                    continue;
                }
                
                String word = s.substring(i - j, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break; // bug 1
                }
            }
        }
        return canSegment[s.length()];
    }
    
    private int getMaxLength(Set<String> dict) {
        int maxLen = 0;
        for (String word : dict) {
            maxLen = Math.max(maxLen, word.length()); 
        }
        return maxLen;
    }
}
