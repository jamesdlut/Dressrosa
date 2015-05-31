/*
Word Ladder II
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
public class WordLadder2Sol {
	public static List<List<String>> findLadders1(String start, String end, Set<String> dict) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if (start == null || end == null || dict == null) {
			return ret;
		}
		HashMap<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
		HashMap<String, List<List<String>>> mapTmp = new HashMap<String, List<List<String>>>();
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		List<List<String>> listStart = new ArrayList<List<String>>();
		List<String> path = new ArrayList<String>();
		path.add(start);
		listStart.add(path);
		map.put(start, listStart);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String s = q.poll();
				int len = s.length();
				for (int j = 0; j < len; j++) {
					StringBuilder sb = new StringBuilder(s);
					for (char c = 'a'; c <= 'z'; c++) {
						sb.setCharAt(j, c);
						String tmp = sb.toString();
						if ((!dict.contains(tmp) && !tmp.equals(end)) || map.containsKey(tmp)) {
							continue;
						}
						List<List<String>> pre = map.get(s);
						List<List<String>> curList = mapTmp.get(tmp);
						if (curList == null) {
							curList = new ArrayList<List<String>>();
							q.offer(tmp);
							mapTmp.put(tmp, curList);
						}
						for (List<String> strList : pre) {
							List<String> strListNew = new ArrayList<String>(strList);
							strListNew.add(tmp);
							curList.add(strListNew);
						}
					}
				}
			}
			if (mapTmp.containsKey(end)) {
				return mapTmp.get(end);
			}
			map.putAll(mapTmp);
		}
		return ret;
	}
	/*
        SOL 2
        bfs: find the shortest length, dfs: find all the shortest solutions
        distance 每个结点到起始结点的距离
        */
	public static List<List<String>> findLadders2(String start, String end, Set<String> dict) {
		List<List<String>> ret = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		HashMap<String, Integer> distance = new HashMap<String, Integer>();
		dict.add(start);
		dict.add(end);
		bfs(map, distance, start, end, dict);
		List<String> path = new ArrayList<String>();
		dfs(map, distance, end, start, path, ret);
		return ret;
	}
	
	private static void bfs(HashMap<String, List<String>> map, HashMap<String, Integer> distance, String start, String end, Set<String> dict) {
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		distance.put(start, 0);
		for (String s : dict) {
			map.put(s, new ArrayList<String>());
		}
		while (!q.isEmpty()) {
			String cur = q.poll();
			List<String> nextList = expand(cur, dict);
			for (String next : nextList) {
				map.get(next).add(cur);
				if (!distance.containsKey(next)) {
					distance.put(next, distance.get(cur) + 1);
					q.offer(next);
				}
			}
		}
	}
	
	private static void dfs(HashMap<String, List<String>> map, HashMap<String, Integer> distance, String cur, String start, List<String> path, List<List<String>> ret) {
		path.add(cur);
		if (cur.equals(start)) {
			Collections.reverse(path);
			ret.add(new ArrayList<String>(path));
			Collections.reverse(path);
		} else {
			for (String next : map.get(cur)) {
				if (distance.containsKey(next) && distance.get(cur) == distance.get(next) + 1) {
					dfs(map, distance, next, start, path, ret);
				}
			}
		}
		path.remove(path.size() - 1);
	}
	
	private static List<String> expand(String cur, Set<String> dict) {
		List<String> expansion = new ArrayList<String>();
		for (int i = 0; i < cur.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != cur.charAt(i)) {
					String expanded = cur.substring(0, i) + c + cur.substring(i + 1);
					if (dict.contains(expanded)) {
						expansion.add(expanded);
					}
				}
			}
		}
		return expansion;
	}
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.print(findLadders2(start, end, dict));
	}
}
