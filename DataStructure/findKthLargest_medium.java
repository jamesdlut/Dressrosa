/*
by yiming
Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
/*
SOL 1
使用改进的Quicksort partition, O(n) time, O(1) space
note: quickselect worst case O(n^2) best/average case O(n)
Choose the last one as the pivot
left: the first one which is bigger than pivot. Change pivot.
*/
public class KthLargestSol {
	// SOL 1 Quick Sort
	public static int findKthLargest1(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
		
		return helper1(nums.length - k + 1, nums, 0, nums.length - 1);
	}
	
	public static int helper1(int x, int[] nums, int start, int end) {
		int pivot = nums[end];
		int left = start;
		int right = end;
		while (true) {
			while (nums[left] < pivot && left < right) {
				left++;
			}
			while (nums[right] >= pivot && right > left) {
				right--;
			}
			if (left == right) {
				break;
			}
			swap(nums, left, right);
		}
		swap(nums, left, end);
		if (x == left + 1) {
			return pivot;
		} else if (x < left + 1) {
			return helper1(x, nums, start, left - 1);
		} else {
			return helper1(x, nums, left + 1, end);
		}
	}
	
	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
	// SOL 2 min heap
	public static int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int len = nums.length;
		Queue<Integer> heap = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			heap.offer(nums[i]);
		}
		for (int j = k; j < len; j++) {
			if (nums[j] > heap.peek()) {
				heap.poll();
				heap.offer(nums[j]);
			} else {
				continue;
			}
		}
		return heap.peek();
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.print(findKthLargest2(nums, k));
	}
}
