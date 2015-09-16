/*
by eamon
Majority Number III
Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array. Find it.
Note
There is only one majority number in the array.
Example
For [3,1,2,3,2,3,3,4,4,4] and k = 3, return 3
Challenge
O(n) time and O(k) extra space
*/
public class MajorNum3Sol {
	public static int majorityNumber(int k, int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else if (map.size() < k) {
				map.put(nums[i], 1);
			} else {
				ArrayList<Integer> tmpList = new ArrayList<Integer>();
				for (Integer n : map.keySet()) {
					tmpList.add(n);
				}
				for (Integer m : tmpList) {
					map.put(m, map.get(m) - 1);
					if (map.get(m) == 0) {
						map.remove(m);
					}
				}
			}
		}
		
		int rst = 0;
		int num = 0;
		for (Integer node : map.keySet()) {
			if (num < map.get(node)) {
				num = map.get(node);
				rst = node;
			}
		}
		return rst;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 1, 2, 3, 2, 3, 3, 4, 4, 4};
		int k = 3;
		System.out.print(majorityNumber(k, nums));
	}
}
