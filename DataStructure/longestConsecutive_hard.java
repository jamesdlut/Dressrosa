/*
Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
*/
/*
SOL 1
Sort & search: space O(1), time O(n logn)
HashMap: space O(n), time O(n)
用HashMap来空间换时间.
1. 在map中创建一些集合来表示连续的空间. 比如, 如果有[3, 4, 5]这样的一个集合, 我们表示为key: 3, value: 5和key: 5, value: 3两个集合, 并且把这2个放在hashmap中. 这样我们可以在O(1)的时间查询某个数字开头和结尾的集合.
2. 来了一个新的数字时, 比如: N=6, 我们可以搜索以N-1结尾, 以N+1开头的集合有没有存在. 从1中可以看到, key: 5是存在的, 这样我们可以删除3, 5和5, 3这两个key-value对, 同样我们要查以7起头的集合有没有存在, 同样可以删除以7起始的集合. 删除后我们可以更新left, right的值, 也就是合并和扩大集合.
3. 合并以上这些集合, 创建一个以新的left, right作为开头, 结尾的集合, 分别以left, right作为key存储在map中. 并且更新max (表示最长连续集合)
remove(Object key)
Removes the mapping for the specified key from this map if present.
SOL 2
把所有的数字放在hashset中, 来一个数字后, 取出HashSet中的某一元素x, 找x - 1, x - 2, ..., x + 1, x + 2, ... 是否也在set里
*/
public class LCSeqSol {
	public static int longestConsecutive1(int[] nums) {
		if (nums == null) {
			return 0;
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (map.get(nums[i]) != null) {
				continue;
			}
			
			int left = nums[i];
			int right = nums[i];
			Integer bound = map.get(nums[i] - 1);
			if (bound != null && bound < left) {
				left = bound;
				map.remove(left);
				map.remove(nums[i] - 1);
			}
			
			bound = map.get(nums[i] + 1);
			if (bound != null && bound > right) {
				right = bound;
				map.remove(right);
				map.remove(nums[i] + 1);
			}
			
			map.put(left, right);
			map.put(right, left);
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
	
	public static int longestConsecutive2(int[] nums) {
		if (nums == null) {
			return 0;
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		int max = 0;
		for (int i : nums) {
			set.remove(i);
			int sum = 1;
			int tmp = i - 1;
			while (set.contains(tmp)) {
				set.remove(tmp);
				sum++;
				tmp--;
			}
			tmp = i + 1;
			while (set.contains(tmp)) {
				set.remove(tmp);
				sum++;
				tmp++;
			}
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.print(longestConsecutive2(nums));
	}
}
