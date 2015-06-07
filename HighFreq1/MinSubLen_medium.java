/*
Minimum Size Subarray Sum
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
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
}
