/*
Sort Colors II
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
注意
You are not suppose to use the library's sort function for this problem.
样例
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4]. 
挑战
A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory.
Can you do it without using extra memory?
*/
/*
SOL 1
使用快排, 时间复杂度是O(nlogn), 空间复杂度是O(1)
SOL 2
inplace, O(N)时间复杂度的算法
使用类似桶排序的思想, 对所有的数进行计数
1. 从左扫描到右边, 遇到一个数字, 先找到对应的bucket, 第一个3对应的bucket是index = 2(bucket从0开始计算)
2. Bucket如果有数字, 则把这个数字移动到i的position(就是存放起来), 然后把bucket记为-1(表示该位置是一个计数器, 计1)
3. Bucket存的是负数, 表示这个bucket已经是计数器, 直接减1. 并把color[i]设置为0(表示此处已经计算过)
4. Bucket存的是0, 与3一样处理, 将bucket设置为-1, 并把color[i]设置为0(表示此处已经计算过)
5. 回到position i, 再判断此处是否为0(只要不是为0, 就一直重复2-4的步骤)
6. 完成1-5的步骤后, 从尾部到头部将数组置结果. (从尾至头是为了避免开头的计数器被覆盖)
e.g.
i = 0  3  2  2  1 4
       2  2 -1  1 4
       2 -1 -1  1 4
       0 -2 -1  1 4
i = 3 -1 -2 -1  0 4
i = 4 -1 -2 -1 -1 0
*/
public class SortColors2Sol {
	public static void sortKColors1(int[] nums, int k) {
		if (nums == null) {
			return;
		}
		
		quickSort(nums, 0, nums.length - 1);
	}
	
	public static void quickSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		
		int pivot = nums[right];
		int pos = partition(nums, left, right, pivot);
		quickSort(nums, left, pos - 1);
		quickSort(nums, pos + 1, right);
	}
	
	public static int partition(int[] nums, int left, int right, int pivot) {
		int leftPoint = left - 1;
		int rightPoint = right;
		
		while (true) {
			while (nums[++leftPoint] < pivot);
			while (leftPoint < rightPoint && nums[--rightPoint] > pivot);
			if (leftPoint >= rightPoint) {
				break;
			}
			swap(nums, leftPoint, rightPoint);
		}
		
		swap(nums, leftPoint, right);
		return leftPoint;
	}
	
	public static void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
	
	public static void sortKColors2(int[] nums, int k) {
		if (nums == null) {
			return;
		}
		
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			while (nums[i] > 0) {
				int val = nums[i];
				if (nums[val - 1] > 0) {
					nums[i] = nums[val - 1];
					nums[val - 1] = -1;
				} else if (nums[val - 1] <= 0) {
					nums[val - 1]--;
					nums[i] = 0;
				}
			}
		}
		
		int index = len - 1;
		for (int i = k - 1; i >= 0; i--) {
			int cnt = -nums[i];
			if (cnt == 0) {
				continue;
			}
			while (cnt > 0) {
				nums[index] = i + 1;
				index--;
				cnt--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 2, 1, 4};
		sortKColors2(nums, 4);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
