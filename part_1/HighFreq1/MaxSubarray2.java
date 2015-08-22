/*
Maximum Subarray II
Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.
Note
The subarray should contain at least one number
Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.
*/
public class MaxSubarray2Sol {
	public static int maxTwoSubArrays(int[] nums) {
		int len = nums.length;
		int[] left = new int[len];
		int[] right = new int[len];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int minSum = 0;
		for (int i = 0; i < len; i++) {
			if (sum < 0) {
                            sum = 0;
                        }
                        sum += nums[i];
                        max = Math.max(max, sum);
                        left[i] = max;
			/*
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(sum, minSum);
			left[i] = max;
			*/
		}
		sum = 0;
		max = Integer.MIN_VALUE;
		minSum = 0;
		for (int i = len - 1; i >= 0; i--) {
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(sum, minSum);
			right[i] = max;
		}
		
		max = Integer.MIN_VALUE;
		for (int i = 0; i < len - 1; i++) {
			max = Math.max(max, left[i] + right[i + 1]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 3, -1, 2, -1, 2};
		System.out.print(maxTwoSubArrays(nums));
	}
}
