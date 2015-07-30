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
public class LongestSubstringSol {
	public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hash.containsKey(s.charAt(i)) == false) {
                hash.put(s.charAt(i), i);
            } else if (hash.containsKey(s.charAt(i)) == true) {
                len = Math.max(hash.size(), len);
                int m = hash.get(s.charAt(i));
                while (m != -1) {
                    hash.remove(s.charAt(m));
                    m--;
                }
                hash.put(s.charAt(i), i);
            }
        }
        return Math.max(hash.size(), len);
    }
	
	public static int lengthOfLongestSubstring2(String s) {
		if (s == null) {
			return 0;
		}
		
		int max = 0;
		int start = 0;
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (hash.containsKey(s.charAt(i)) && hash.get(s.charAt(i)) >= start) {
				start = hash.get(s.charAt(i)) + 1;
			}
			hash.put(s.charAt(i), i);
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
	
	public static int lengthOfLongestSubstring3(String s) {
		if (s == null) {
			return 0;
		}
		
		int max = 0;
		int[] lastIndex = new int[128];
		for (int i = 0; i < 128; i++) {
			lastIndex[i] = -1;
		}
		
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (lastIndex[c] >= start) {
				start = lastIndex[c] + 1;
			}
			lastIndex[c] = i;
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		String s1 = "abba";
		String s2 = "aa";
		System.out.print(lengthOfLongestSubstring3(s1));
	}
}
