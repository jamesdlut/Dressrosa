/*
Largest Number
Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.
*/
/*
贪心思路: 对于两个备选数字a和b, 如果str(a) + str(b) > str(b) + str(a), 则a在b之前, 否则b在a之前
按照此原则对原数组从大到小排序即可
时间复杂度O (nlogn)
易错样例：
Input: [0,0]
Output: "00"
Expected: "0"
*/
public class LargestNumSol {
	public static String largestNumber(int[] nums) {
		if (nums == null) {
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : nums) {
			list.add(i);
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String s1 = "" + o1 + o2;
				String s2 = "" + o2 + o1;
				return s2.compareTo(s1);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i);
		}
		
		if (sb.charAt(0) == '0') {
			return "0";
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.print(largestNumber(nums));
	}
}
