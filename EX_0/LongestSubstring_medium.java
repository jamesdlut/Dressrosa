/*
3 Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
/*
SOL 1 Time Limited
SOL 2 
使用一个start来记录起始的index, 判断在hash时顺便判断一下那个重复的字母是不是在index之后. 如果是, 把start = map.get(c) + 1即可. 并且即时更新char的最后索引.
SOL 3
假定所有的字符都是ASCII码, 则我们可以使用数组来替代Map, 代码更加简洁
*/
