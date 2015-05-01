/*
Find Peak Element
A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞.
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
Note:
Your solution should be in logarithmic complexity.
*/
/*
mid是峰，mid是谷，mid是上升的中点，mid是下降的中点
基本上就是三个条件：A: 我自己是峰，B，左边有一个峰，C，右边有一个峰
只要发现mid比mid-1或者mid+1的任何一边的小，就往那边走就行
*/
/*
5316 start = 5 end = 6 mid = 3 -> start = 5 end = 3 5 > 3 thus return 5
1239 start = 1 end = 9 mid = 2 -> start = 2 end = 9 mid = 3 -> start = 3 end = 9 3 < 9 thus return 9
*/
public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null) {
            return -1;
        }
        if (num.length == 1) {
            return 0;
        }
        
        int start, mid, end;
        start = 0;
        end = num.length - 1;
        while (start + 1 < end) {
            mid  = start + (end - start) / 2;
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
                return mid;
            } else if (num[mid] > num[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (num[start] > num[start + 1]) {
            return start;
        } 
        if (num[end] > num[end - 1]) {
            return end;
        }
        return -1;
    }
}
