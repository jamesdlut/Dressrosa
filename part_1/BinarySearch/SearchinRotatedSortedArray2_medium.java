/*
Search in Rotated Sorted Array II
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.
*/
/*
考点：不能用二分法，基于比较的排序，最快nlogn
黒盒测试，访问A数组，内容未知，很可能前面很多重复的无关元素，而target在最后一个，没有查询到所有元素之前都无法确定
*/
public class Solution {
    public boolean search(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
