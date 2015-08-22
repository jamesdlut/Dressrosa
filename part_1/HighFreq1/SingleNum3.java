/*
Single Number III
Given 2 * n + 2 numbers, every numbers occurs twice except two, find them.
Example
Given [1, 2, 2, 3, 4, 4, 5, 3] return 1 and 5
Challenge
O(n) time, O(1) extra space.
*/
/*
2n + 2 => 2n’ + 1, 2n’’ + 1
s ^= x -> s = 001^101 = 100
从某一位上分两拨, 把a和b分开, 剩下的数, 仍然成双成对在某个组出现
*/
/*
00000000000000000000000000000100 -> s 32bits 
11111111111111111111111111111011 
00000000000000000000000000000100 -> -s (~s + 1) 取反加1
————————————————————————————————
00000000000000000000000000000100 -> y
*/
public class SingleNum3Sol {
	public static List<Integer> singleNumber(int[] nums) {
		List<Integer> rst = new ArrayList<Integer>();
		int s = 0;
		for (int x : nums) {
			s ^= x;
		}
		// int y = s & (-s);
		int[] ans = new int[2];
		for (int x : nums) {
			if ((x & s) != 0) {
				ans[0] ^= x;
			} else {
				ans[1] ^= x;
			}
		}
		for (int i : ans) {
			rst.add(i);
		}
		return rst;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3, 4, 4, 5, 3};
		System.out.print(singleNumber(nums));
	}
}
