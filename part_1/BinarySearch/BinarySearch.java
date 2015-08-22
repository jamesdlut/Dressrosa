/*
by yiming
Binary search is a famous question in algorithm. For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity. If the target number does not exist in the array, return -1. Example If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
*/
/*
T(n) = T(n / 2) + O(1)
T(n)
T(n / 2) T(n / 2)
T(n / 2^2) T(n / 2^2) T(n / 2^2) T(n / 2^2)
...
n / 2^x = 1, thus x = logn
*/
/*
after the while loop, start + 1 = end, that is, 
start和end已经相邻，所以在这里判断到底是谁等于target，由此决定输出哪个量来作为结果
consider test case target = 1 1(start) 2(end) 3 4 5 6 7 8
*/
public class Solution {
    public int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2; // (start + end) / 2 may stackoverflow due to too large value
            if (nums[mid] == target) {
                end = mid; // 相邻即退出循环，解决了相邻重复数取前取后的问题
            } else if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid; 
            }
        }
        
        if (nums[end] == target) {
            return end;
        } else if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
