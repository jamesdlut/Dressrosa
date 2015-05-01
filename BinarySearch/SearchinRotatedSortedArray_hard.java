/*
by yiming
Search in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
*/
/*
画图解题
*/
public class Solution {
    public int search(int[] A, int target) {
        int start, mid, end;
        start = 0;
        end = A.length - 1;
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) { 
                return mid;
            }
            if (A[mid] > A[start]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } 
        return -1;
    }
}
