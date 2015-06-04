/*
Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/
/*
两个数不一样就抵消掉
要对majority number进行检查, 以排除不存在majority number的情况. 如1, 2, 3, 4这样的数列, 是没有majory number的.
*/
public class MajorNumSol {
	public static int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int maj = nums[0];
		int len = nums.length;
		// SOL 1 Voting
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			if (cnt == 0) {
				maj = nums[i];
				cnt++;
			} else if (nums[i] == maj) {
				cnt++;
			} else {
				cnt--;
			}
		}
		// SOL 2 Examing
		/*
		cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == maj) {
				cnt++;
			}
		}
		*/
		if (cnt <= nums.length / 2) {
			return -1;
		}
		
		return maj;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.print(majorityElement(nums));
	}
}
