/*
Minimum Subarray
Given an array of integers, find the subarray with smallest sum.
Return the sum of the subarray.
Note
The subarray should contain at least one integer.
Example
For [1, -1, -2, 1], return -3
*/
public class MinSubSol {
	public static int minSubArray1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int maxSum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			min = Math.min(min, sum - maxSum);
			maxSum = Math.max(sum, maxSum);
			/*
			if (sum > 0) {
				sum = 0;
			}
			sum += nums[i];
			min = Math.min(min, sum);
			*/
		}
		return min;
	}
	// 取反
	public static int minSubArray2(int[] nums) {
		int len = nums.length;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			if (sum < 0) {
				sum = -nums[i];
			} else {
				sum += -nums[i];
			}
			max = Math.max(max, sum);
		}
		return -max;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, -1, -2, 1};
		System.out.print(minSubArray2(nums));
	}
}
