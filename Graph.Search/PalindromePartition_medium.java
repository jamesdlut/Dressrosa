/*
Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
/*
time O(2^N)
*/
public class partitionSol {
	// SOL 1 DFS
	public static List<List<String>> partition1(String s) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if (s == null) {
			return ret;
		}
		dfs1(s, 0, new ArrayList<String>(), ret);
		return ret;
	}
	
	public static void dfs1(String s, int index, List<String> path, List<List<String>> ret) {
		int len = s.length();
		if (index == len) {
			ret.add(new ArrayList<String>(path));
			return;
		}
		
		for (int i = index; i < len; i++) {
			String sub = s.substring(index, i + 1);
			if (!isPalindrome1(sub)) {
				continue;
			}
			path.add(sub);
			dfs1(s, i + 1, path, ret);
			path.remove(path.size() - 1);
		}
	}
	
	public static boolean isPalindrome1(String s) {
		int len = s.length();
		int left = 0;
		int right = len - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	// SOL 2 DFS + HashMap
	public static List<List<String>> partition2(String s) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if (s == null) {
			return ret;
		}
		dfs2(s, 0, new ArrayList<String>(), ret, new HashMap<String, Boolean>());
		return ret;
	}
	
	public static void dfs2(String s, int index, List<String> path, List<List<String>> ret, HashMap<String, Boolean> map) {
		int len = s.length();
		if (index == len) {
			ret.add(new ArrayList<String>(path));
			return;
		}
		for (int i = index; i < len; i++) {
			String sub = s.substring(index, i + 1);
			if (!isPalindrome2(sub, map)) {
				continue;
			}
			path.add(sub);
			dfs2(s, i + 1, path, ret, map);
			path.remove(path.size() - 1);
		}
	}
	
	public static boolean isPalindrome2(String s, HashMap<String, Boolean> map) {
		int len = s.length();
		int left = 0;
		int right = len - 1;
		if (map.get(s) != null) {
			return map.get(s);
		}
		// map.put(s, true);
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				map.put(s, false);
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	// SOL 3 DP + DFS
    public static List<List<String>> partition3(String s) {
    	List<List<String>> ret = new ArrayList<List<String>>();
    	if (s == null) {
    		return ret;
    	}
    	int len = s.length();
    	boolean[][] D = new boolean[len][len];
    	for (int j = 0; j < len; j++) {
    		for (int i = 0; i <= j; i++) {
    			D[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || D[i + 1][j - 1]);
    		}
    	}
    	dfs3(s, 0, new ArrayList<String>(), ret, D);
    	return ret;
    }
    
    public static void dfs3(String s, int index, List<String> path, List<List<String>> ret, boolean[][] D) {
    	int len = s.length();
    	if (index == len) {
    		ret.add(new ArrayList<String>(path));
    		return;
    	}
    	for (int i = index; i < len; i++) {
    		String sub = s.substring(index, i + 1);
    		if (!D[index][i]) {
    			continue;
    		}
    		path.add(sub);
    		dfs3(s, i + 1, path, ret, D);
    		path.remove(path.size() - 1);
    	}
    }
    
	public static void main(String[] args) {
		String test = "abb";
		System.out.print(partition3(test));
	}
}
