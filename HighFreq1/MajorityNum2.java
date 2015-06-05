/*
Majority Number II
Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.
Find it.
Note
There is only one majority number in the array
Example
For [1, 2, 1, 2, 1, 3, 3] return 1
Challenge
O(n) time and O(1) space
*/
/*
对cnt1, cnt2减数时, 相当于丢弃了3个数字(当前数字, n1, n2). 也就是说, 每一次丢弃数字, 我们是丢弃3个不同的数字.
而Majority number超过了1/3所以它最后一定会留下来.
*/
public class MajorNum2Sol {
	public static int majorityNumber(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return -1;
		}
		
		int n1 = 0;
		int n2 = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (cnt1 != 0 && nums[i] == n1) {
				cnt1++;
			} else if (cnt2 != 0 && nums[i] == n2) {
				cnt2++;
			} else if (cnt1 == 0) {
				cnt1 = 1;
				n1 = nums[i];
			} else if (cnt2 == 0) {
				cnt2 = 1;
				n2 = nums[i];
			} else {
				cnt1--;
				cnt2--;
			}
		}
		
		cnt1 = 0;
		cnt2 = 0;
		for (int num : nums) {
			if (num == n1) {
				cnt1++;
			} else if (num == n2) {
				cnt2++;
			}
		}
		
		if (cnt1 < cnt2) {
			return n2;
		}
		return n1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 2, 3, 2, 4, 4, 4};
		System.out.print(majorityNumber(nums));
	}
}
