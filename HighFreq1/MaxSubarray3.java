/*
Maximum Subarray III
Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.
Note
The subarray should contain at least one number
Example
Given [-1,4,-2,3,-2,3],k=2, return 8
*/
/*
DP d[i][j] means the maximum sum we can get by selecting i subarrays from the first j elements.
*/
public class MaxSubarray3Sol {
	public static int maxSubArray(int[] nums, int k) {
		if (nums.length < k) {
			return 0;
		}
		
		int len = nums.length;
		int[][] d = new int[k + 1][len + 1];
		for (int i = 0; i <= len; i++) {
			d[0][i] = 0;
		}
		
		for (int i = 1; i <= k; i++) {
			for (int j = i; j <= len; j++) {
				d[i][j] = Integer.MIN_VALUE;
				int endMax = 0;
				int max = Integer.MIN_VALUE;
				for (int p = j - 1; p >= i - 1; p--) {
					endMax = Math.max(nums[p], endMax + nums[p]);
					max = Math.max(endMax, max);
					d[i][j] = Math.max(d[i][j], d[i - 1][p] + max);
				}
			}
		}
		return d[k][len];
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 4, -2, 3, -2, 3};
		int k = 2;
		System.out.print(maxSubArray(nums, k));
	}
}
