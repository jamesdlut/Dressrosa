/*
Sort Colors
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note:
You are not suppose to use the library's sort function for this problem.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
*/
/*
SOL 1
类似radix sort, 先扫描一次得知所有的值出现的次数, 再依次setup它们即可
SOL 2
使用双指针指向左边排好的0和右边排好的2, 再加一个指针cur扫描整个数组. 一趟排序下来就完成了. 
注意: 与右边交换之后, cur不能移动, 因为你有可能交换过来是1或是0, 还需要与左边交换. 而与左边交换后, cur就可以向右边移动了.
非常要注意的是, 我们要使用cur <= right作为边界值. 因为right指向的是未判断的值. 所以当cur == right时, 此值仍然需要继续判断
*/
public class SortColorsSol {
	// SOL 1 two pass
	public static void sortColors1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		int len = nums.length;
		int red = 0;
		int white = 0;
		int blue = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				red++;
			} else if (nums[i] == 1) {
				white++;
			} else {
				blue++;
			}
		}
		
		for (int i = 0; i < len; i++) {
			if (red > 0) {
				nums[i] = 0;
				red--;
			} else if (white > 0) {
				nums[i] = 1;
				white--;
			} else {
				nums[i] = 2;
			}
		}
	}
	// SOL 2 one pass
	public static void sortColors2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		int len = nums.length - 1;
		int left = 0;
		int right = len;
		int cur = 0;
		while (cur <= right) {
			if (nums[cur] == 2) {
				swap(nums, cur, right);
				right--;
			} else if (nums[cur] == 0) {
				swap(nums, cur, left);
				left++;
				cur++;
			} else {
				cur++;
			}
		}
	}

	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
	// SOL 3
	public static void sortColors3(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		int left = 0;
		int right = nums.length - 1;
		int cur = 0;
		while (cur <= right) {
			switch (nums[cur]) {
			case 0:
				swap(nums, left, cur);
				left++;
				cur++;
				break;
			case 1:
				cur++;
				break;
			case 2:
				swap(nums, cur, right);
				right--;
				break;
			default:
				cur++;
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 0, 1, 2};
		sortColors3(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
