/*
Subarray Sum
Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
*/
/*
使用Map来记录index, sum的值. 当遇到两个index的sum相同时, 表示从index1+1到index2是一个解
注意: 添加一个index = -1作为虚拟节点. 这样我们才可以记录index1 = 0的解
time O(n) space O(n)
*/
public class SubSumSol {
	public static List<Integer> subarraySum(int[] nums) {
		int len = nums.length;
		List<Integer> rst = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				rst.add(map.get(sum) + 1);
				rst.add(i);
				return rst;
			}
			map.put(sum, i);
		}
		return rst;
	}
	
	public static void main(String[] args) {
		int[] nums = {-3, 1, 2, -3, 4};
		System.out.print(subarraySum(nums));
	}
}
/*
 *outputs:
 *[0, 2]
 */
