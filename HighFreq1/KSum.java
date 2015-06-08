/*
k Sum
Given n distinct positive integers, integer k (k <= n) and a number target.
Find k numbers where sum is target. Calculate how many solutions there are?
Example
Given [1,2,3,4], k=2, target=5. There are 2 solutions:
[1,4] and [2,3], return 2.
*/
/*
D[i][j][t]前i个数中, 挑出j个数, 组成和为t有多少方案
D[0][0][0]表示在一个空集中找出0个数, target为0, 则有1个解, 就是什么也不挑
(1) 我们可以把当前A[i - 1]这个值包括进来, 所以需要加上D[i - 1][j - 1][t - A[i - 1]] (前提是t - A[i - 1]要大于0)
(2) 我们可以不选择A[i - 1]这个值, 这种情况就是D[i - 1][j][t], 也就是说直接在前i - 1个值里选择一些值加到target.
*/
public class KSumSol {
	public static int kSum(int nums[], int k, int target) {
		if (target < 0) {
			return 0;
		}
		
		int len = nums.length;
		int[][][] d = new int[len + 1][k + 1][target + 1];
		
		for (int i = 0; i < len + 1; i++) {
			for (int j = 0; j < k + 1 && j <= i; j++) {
				for (int t = 0; t <= target; t++) {
					if (j == 0 && t == 0) {
						d[i][j][t] = 1;
					} else if (!(i == 0 || j == 0 || t == 0)) {
						d[i][j][t] = d[i - 1][j][t];
						if (t - nums[i - 1] >= 0) {
							d[i][j][t] += d[i - 1][j - 1][t - nums[i - 1]];
						}
					}
				}
			}
		}
		return d[len][k][target];
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.print(kSum(nums, 2, 5));
	}
}
