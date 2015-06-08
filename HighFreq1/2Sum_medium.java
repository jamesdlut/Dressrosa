/*
Two Sum
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
/*
consider {3, 2, 4} target = 6
{3, 3} {2, 4}
*/
public class TwoSumSol {
	public static int[] twoSum1(int[] nums, int target) {
		int[] index = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i + 1);
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				index[0] = i + 1;
				index[1] = map.get(target - nums[i]);
				if (index[0] == index[1]) {
					continue;
				}
				return index;
			}
		}
		return index;
	}
	// Can’t use the sort method here, since the question asks for indexes.
	public static int[] twoSum2(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}
		
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int[] index = new int[2];
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				index[0] = left + 1;
			    index[1] = right + 1;
			    break;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int[] rst = twoSum2(nums, 9);
		for (int i = 0; i < rst.length; i++) {
			System.out.print(rst[i] + " ");
		}
	}
}
