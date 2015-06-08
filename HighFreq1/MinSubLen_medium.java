/*
Minimum Size Subarray Sum
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/
/*
SOL 1 Sliding Window
滑动窗口, 若小于s, 把右边界往右滑动扩大窗口, 否则把左边界往右滑, 缩小窗口, 所有的数都是正数
SOL 2 Binary Search 
sums[i] - target = sums[i] - sums[i] + s - 1 < sums[i] - sums[end] = s
*/
public class Solution {
    public int minSubArrayLen1(int s, int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int rst = nums.length + 1;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                if (right - left + 1 == 1) {
                    return 1;
                }
                rst = Math.min(rst, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if (rst > nums.length) {
            return 0;
        } else {
            return rst;
        }
    }
    
    public int minSubArrayLen2(int s, int[] nums) {
        int len = nums.length;
        int[] sums = new int[len + 1];
        sums[0] = 0;
        for (int i = 1; i < len + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        int rst = Integer.MAX_VALUE;
        for (int i = 1; i < len + 1; i++) {
            if (sums[i] >= s) {
                int end = binarySearch(0, i, sums[i] - s + 1, sums);
                if (end != -1 && i - end < rst) {
                    rst = i - end;
                }
            }
        }
        
        if (rst == Integer.MAX_VALUE) {
            return 0;
        } else {
            return rst;
        }
    }
    
    private int binarySearch(int start, int end, int target, int[] sums) {
        if (start >= end) {
            return -1;
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sums[mid] == target) {
                end = mid - 1;
            } else if (sums[mid] > target) {
                end = mid - 1;
            } else if (sums[mid] < target) {
                start = mid;
            }
        }
        if (sums[end] < target) {
            return end;
        } else if (sums[start] < target) {
            return start;
        } else return -1;
    }
}
