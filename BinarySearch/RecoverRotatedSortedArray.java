/*
by yiming
Recover Roatated Sorted Array
Given a rotated sorted array, recover it to sorted array in-place. Example [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
*/
/*
Class ArrayList 
.set(index, object): Replaces the element at the specified position in this list with the specified element.
*/
public class Solution { 
/**
* @param nums: The rotated sorted array 
* @return: The recovered sorted array
*/
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverseArray(nums, 0, i);
                reverseArray(nums, i + 1, nums.size() - 1);
                reverseArray(nums, 0, nums.size() - 1);
                return;
            }
        }
    }
    
    public void reverseArray(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
    }
}
