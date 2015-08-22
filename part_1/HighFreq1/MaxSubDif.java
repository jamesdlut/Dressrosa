/*
Maximum Subarray Difference
Given an array with integers.
Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
Return the largest difference.
Note
The subarray should contain at least one number
Example
For [1, 2, -3, 1], return 6
Challenge
O(n) time and O(n) space.
*/
public class MaxDiffSol {
	public static int maxDiffSubArrays(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		
		int[] leftMin = new int[len];
		int[] leftMax = new int[len];
		int endMin = nums[0];
		int endMax = nums[0];
		leftMin[0] = endMin;
		leftMax[0] = endMax;
		for (int i = 1; i < len; i++) {
			endMax = Math.max(nums[i], nums[i] + endMax);
			leftMax[i] = Math.max(leftMax[i - 1], endMax);
			endMin = Math.min(nums[i], nums[i] + endMin);
			leftMin[i] = Math.min(leftMin[i - 1], endMin);
		}
		
		int[] rightMin = new int[len];
		int[] rightMax = new int[len];
		endMin = nums[len - 1];
		endMax = nums[len - 1];
		rightMin[len - 1] = endMin;
		rightMax[len - 1] = endMax;
		for (int i = len - 2; i >= 0; i--) {
			endMax = Math.max(nums[i], nums[i] + endMax);
			rightMax[i] = Math.max(rightMax[i + 1], endMax);
			endMin = Math.min(nums[i], nums[i] + endMin);
			rightMin[i] = Math.min(rightMin[i + 1], endMin);
		}
		
		int maxDiff = 0;
		for (int i = 0; i < len - 1; i++) {
			if (maxDiff < Math.abs(leftMin[i] - rightMax[i + 1])) {
				maxDiff = Math.abs(leftMin[i] - rightMax[i + 1]);
			}
			if (maxDiff < Math.abs(leftMax[i] - rightMin[i + 1])) {
				maxDiff = Math.abs(leftMax[i] - rightMin[i + 1]);
			}
		}
		return maxDiff;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, -3, 1};
		System.out.print(maxDiffSubArrays(nums));
	}
}
