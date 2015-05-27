/*
Permutations
Given a collection of numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
/*
求所有可能解用dfs, time O(n!)
rst 存所有的构造的排列 可行的方案 list 当前可行的可行解 num 可取的数目,
遍历num 看数曾经是否被选取, 若没被选取, 加到list,
dfs search遍历完一个, 进入下一个新的dfs,
取下一个数, 把之前那个数remove, 加入了一个元素, 尝试取下一个元素. 
*/
public class permuteSol {
	public static List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return rst;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		helper1(rst, list, nums);
		return rst;
	}
	
	public static void helper1(List<List<Integer>> rst, List<Integer> list, int[] nums) {
		// list = new ArrayList<Integer>();
		if (list.size() == nums.length) {
			rst.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i])) {
				continue;
			}
			list.add(nums[i]);
			helper1(rst, list, nums);
			list.remove(list.size() - 1);
		}
	}
	
	public static List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return rst;
		}
		
		helper2(rst, nums, new LinkedHashMap<Integer, Integer>());
		return rst;
	}
	
	public static void helper2(List<List<Integer>> rst, int[] nums, LinkedHashMap<Integer, Integer> set) {
		if (set.size() == nums.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (Integer i : set.keySet()) {
				list.add(i);
			}
			rst.add(list);
			return;
		}
		
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (set.containsKey(nums[i])) {
				continue;
			}
			set.put(nums[i], 0);
			helper2(rst, nums, set);
			set.remove(nums[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.print(permute1(nums));
		System.out.print("\n");
		System.out.print(permute2(nums));
	}
}
