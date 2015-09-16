/*
Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
/*
version 1: find the first position >= target
*/
public class Solution {
    public int searchInsert(int[] A, int target) {
        int start, mid, end;
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            }
        }
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
/*
version 2: find the last position < target, return + 1
*/
public class Solution {
    public int searchInsert(int[] A, int target) {
        int start, mid, end;
        start = 0;
        end = A.length - 1;
        if (target < A[0]) {
            return 0;
        }
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            }
        }
        if (A[end] == target) {
            return end;
        } else if (A[end] < target) {
            return end + 1;
        } else if (A[start] == target){
            return start;
        } else {
            return start + 1;
        }
    }
}
