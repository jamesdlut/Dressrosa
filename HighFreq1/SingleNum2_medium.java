/*
by eamon
Single Number II
Given an array of integers, every element appears three times except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
/*
SOL 1 time O(n), space O(n)
SOL 2 time O(n), space O(1)
*/
public class SingleNum2Sol {
	public static int singleNumber1(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer cnt = map.get(nums[i]);
			if (cnt != null) {
				map.put(nums[i], cnt + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		
		Set<Integer> set = map.keySet();
		for (Integer i : set) {
			if (map.get(i) != 3) {
				return i;
			}
		}
		return 0; 
	}
	
	public static int singleNumber2(int[] nums) {
		if (nums == null) {
			return 0;
		}
		
		int cur = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					sum++;
					sum = sum % 3;
				}
			}
			cur |= sum << i;
		}
		return cur;
	}
	
	public static void main(String[] args) {
		int[] nums = {7, 5, 4, 4, 4, 5, 5};
		System.out.print(singleNumber2(nums));
	}
}
