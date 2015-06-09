/*
Interleaving Positive and Negative Numbers
Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
Note
You are not necessary to keep the original order or positive integers or negative integers.
Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other legal answer.
Challenge
Do it in-place and without extra memory.
*/
/*
1. Put all the positive numbers at in the left part.
2. Have more Positive numbers. Reverse the array. 
3. Reorder the negative and the positive numbers.
*/
public class InterleaveNumSol {
	public static int[] rerange(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return nums;
		}
		
		int len = nums.length;
		int cntPositive = 0;
		
		for (int num : nums) {
			if (num > 0) {
				cntPositive++;
			}
		}
		
		int i1 = 0;
		for (int i2 = 0; i2 < len; i2++) {
			if (nums[i2] > 0) {
				swap(nums, i1, i2);
				i1++;
			}
		}
		
		int posPointer = 1;
		int negPointer = 0;
		if (cntPositive > nums.length / 2) {
			posPointer = 0;
			negPointer = 1;
			int left = 0;
			int right = len - 1;
			while (left < right) {
				swap(nums, left, right);
				left++;
				right--;
			}
		}
		
		while (true) {
			while (posPointer < len && nums[posPointer] > 0) {
				posPointer += 2;
			}
			while (negPointer < len && nums[negPointer] < 0) {
				negPointer += 2;
			}
			if (posPointer >= len || negPointer >= len) {
				break;
			}
			swap(nums, posPointer, negPointer);
		}
		return nums;
	}
	
	private static void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, -2, -3, 4, 5, 6};
		rerange(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
/*
 * outputs:
 * -1 5 -3 4 -2 6 
 */
