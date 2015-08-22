/*
Maximum Product Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
/*
DP 
因为有正负值好几种情况, 所以计算当前节点最大值, 最小值时, 应该考虑前一位置的最大值, 最小值几种情况
e.g. 如果当前为-2, 前一个位置最小值为-6, 最大值为8, 那么当前最大值应该是-2 * -6 = 12
对于以index位置结尾的连续子串来说, 计算最大, 最小值可以三种选择: 
1. 当前值 * 前一位置的最大值
2. 当前值 * 前一位置的最小值(若当前值负, 则最大)
3. 丢弃前一位置的所有的值
对这三项取最大值, 最小值, 就可以得到当前的最大乘积, 最小乘积
*/
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 1;
        int min = 1;
        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n1 = max * nums[i];
            int n2 = min * nums[i];
            max = Math.max(nums[i], Math.max(n1, n2));
            min = Math.min(nums[i], Math.min(n1, n2));
            rst = Math.max(max, rst);
        }
        return rst;
    }
}
