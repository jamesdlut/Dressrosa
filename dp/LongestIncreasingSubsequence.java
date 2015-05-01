/*
by yiming
Longest Increasing Subsequence
Given a sequence of integers, find the longest increasing subsequence (LIS). You code should return the length of the LIS. Example For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3 For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
*/
/*
194567 follow the instruction of problem should return 14567 
i = 0 f[0] = 1 
i = 1 f[1] = 1 j = 0 nums[1] > nums[0] f[1] = max(1, f[0] + 1) = 2 max = 2
i = 2 f[2] = 1 j = 0 nums[2] > nums[0] f[2] = max(1, f[0] + 1) = 2 nums[2] < nums[1] max = 2
i = 3 f[3] = 1 j = 0 nums[3] > nums[0] f[3] = 2 nums[3] < nums[1] nums[3] > nums[2] f[3] = max(f[3], f[2] + 1) = 3
i = 4 f[4] = 1 j = 0 nums[4] > nums[0] f[4] = 2 nums[4] < nums[1] nums[4] > nums[2] f[4] = max(f[4], f[2] + 1) = 3 nums[4] > nums[3] f[4] = max(f[4], f[3] + 1) = 4
i = 5 f[5] = 1 j = 0 nums[5] > nums[0] f[5] = 2 nums[5] < nums[1] nums[5] > nums[2] f[5] = max(f[5], f[2] + 1) = 3 nums[5] > nums[3] f[5] = max(f[5], f[3] + 1) = 4 nums[5] > nums[4] f[5] = max(f[5], f[4] + 1) = 5
*/
public class Solution {
    public int longestIncreasingSubsequence(vector<int> nums) {
    
        int[] f = new int[nums.size()];
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            f[i] = 1; 
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                     f[i] = Math.max(f[i], f[j] + 1);
                } 
            }
            if (f[i] > max) {
                 max = f[i];
            }
        }
        return max;
    }
}
