/*
Word Ladder 
Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
/*
经典的BFS题目
想象一下, 这个变换过程是一个树, 每一层是当前所有的变换结果, 下一层又是上一层的字符串的所有的变换结果.
e.g.
HIT
AIT, BIT, CIT, DIT...
HAT, HBT, HCT, HDT...
HIA, HIB, HIC, HID...
HIT可以有这么多种变换方式, 而AIT, BIT本身也可以以相同的方式展开, 这就形成了一个相当大的树
*/
/*
public StringBuilder(String str)
Constructs a string builder initialized to the contents of the specified string.
*/
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord == null || endWord == null || wordDict == null) {
            return 0;
        }
        
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        HashSet<String> set = new HashSet<String>();
        set.add(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                int len = s.length();
                for (int j = 0; j < len; j++) {
                    StringBuilder sb = new StringBuilder(s);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String tmp = sb.toString();
                        if (tmp.equals(endWord)) {
                            return level;
                        }
                        if (set.contains(tmp) || !wordDict.contains(tmp)) {
                            continue;
                        }
                        set.add(tmp);
                        q.offer(tmp);
                    }
                }
            }
        }
        return 0;
    }
}
