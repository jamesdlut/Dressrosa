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
