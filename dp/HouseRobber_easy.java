/*
by yiming
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
/*
time O(n)
dp[i][1] means we rob the current house and dp[i][0] means we don't,
num has num.length houses: 0~(num.length - 1); plus one more node to store the result after adding num[num.length - 1], thus the size should be defined num.length + 1.
*/
/*
e.g. 一个数组，选出不相邻子序列，要求子序列和最大，
[4,9,6]=10
[4,10,3,1,5]=15
follow up问到如何测试，测试用例设计，时间空间复杂度
*/
public class Solution {
    public int rob(int[] num) {
        int[][] dp = new int[num.length + 1][2]; 
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = num[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }
}
