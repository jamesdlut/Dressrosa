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
SOL 1
d[i][j] means the maximum sum we can get by selecting j subarrays from the first i elements.
SOL 2
DP d[i][j] means the maximum sum we can get by selecting j subarrays from the first i elements.
time O(len^2 * k)
*/
public class MaxSubarray3Sol {
	public static int maxSubArray1(int[] nums, int k) {
		int len = nums.length;
		if (len < k) {
			return 0;
		}
		
		int[][] d = new int[len + 1][k + 1];
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= k; j++) {
				if (i < j) {
					d[i][j] = 0;
					continue;
				}
				d[i][j] = Integer.MIN_VALUE;
				for (int p = j - 1; p <= i - 1; p++) {
					int local = nums[p];
					int global = local;
					for (int t = p + 1; t <= i - 1; t++) {
						local = Math.max(local + nums[t], nums[t]);
						global = Math.max(local, global);
					}
					if (d[i][j] < d[i][j - 1] + global) {
						d[i][j] = d[p][j - 1] + global;
					}
				}
			}
		}
		return d[len][k];
	}
	
	public static int maxSubArray2(int[] nums, int k) {
		if (nums.length < k) {
			return 0;
		}
		
		int len = nums.length;
		int[][] d = new int[len + 1][k + 1];
		for (int i = 0; i <= len; i++) {
			d[i][0] = 0;
		}
		
		for (int j = 1; j <= k; j++) {
			for (int i = j; i <= len; i++) {
				d[i][j] = Integer.MIN_VALUE;
				int endMax = 0;
				int max = Integer.MIN_VALUE;
				for (int p = i - 1; p >= j - 1; p--) {
					endMax = Math.max(nums[p], endMax + nums[p]);
					max = Math.max(endMax, max);
					d[i][j] = Math.max(d[i][j], d[p][j - 1] + max);
				}
			}
		}
		return d[len][k];
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 4, -2, 3, -2, 3};
		int k = 2;
		System.out.print(maxSubArray2(nums, k));
	}
}
