/*
Subsets II
Given a list of numbers that may has duplicate numbers, return all possible subsets
Example
If S = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Note
Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
*/
public class Subsets2Sol {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return rst;
		}
		Arrays.sort(nums);
		helper(rst, list, nums, 0);
		return rst;
	}
	
	public static void helper(List<List<Integer>> rst, List<Integer> list, int[] nums, int pos) {
		rst.add(new ArrayList<Integer>(list));
		for (int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i] == nums[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			helper(rst, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] test = {1, 2, 2};
		System.out.print(subsetsWithDup(test));
	}
}
