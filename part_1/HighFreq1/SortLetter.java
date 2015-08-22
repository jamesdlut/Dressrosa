/*
Sort Letters by Case
Given a string which contains only letters. Sort it by lower case first and upper case second.
Note
It's not necessary to keep the original order of lower-case letters and upper case letters.
Example
For "abAcD", a reasonable answer is "acbAD"
*/
public class SortLettersSol {
	public static void sortLetters(char[] nums) {
		int low = 0;
		int cap = nums.length - 1;
		while (low < cap) {
			while (low < cap && nums[low] >= 'a' && nums[low] <= 'z') {
				low++;
			}
			while (low < cap && nums[cap] >= 'A' && nums[cap] <= 'Z') {
				cap--;
			}
			
			char tmp = nums[low];
			nums[low] = nums[cap];
			nums[cap] = tmp;
		}
	}
	
	public static void main(String[] args) {
		char[] nums = {'a', 'b', 'A', 'c', 'D'};
		sortLetters(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
