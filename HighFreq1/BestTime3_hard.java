/*
Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
/*
SOL 1
1. 从左往右扫描, 计算0-i的这个区间的最大利润. 方法可以参见股票第一题.
2. 从右往左扫描, 计算i-len这个区间的最大利润.
3. 再从头至尾扫一次, 每个节点加上左边和右边的利润. 记录最大值.
O(n^2)的算法很容易想到:
找寻一个点j, 将原来的prices[0..n - 1]分割为prices[0..j]和prices[j..n - 1], 分别求两段的最大profit.
进行优化: 
对于点j + 1, 求prices[0..j + 1]的最大profit时, 很多重复的工作在求prices[0..j]的最大profit中已经做过了,
类似于Best Time to Buy and Sell Stock, 可以在O(1)的时间从prices[0..j]推出prices[0..j + 1]的最大profit,
但是如何从prices[j..n - 1]推出prices[j + 1..n - 1]? 反过来思考, 我们可以用O(1)的时间由prices[j + 1..n - 1]推出prices[j..n - 1]
数组left[i]记录了prices[0..i]的最大profit,
数组right[i]记录了prices[i..n]的最大profit.
已知left[i], 求left[i + 1]. 已知right[i], 求right[i - 1].
用O(n)的时间找出最大的left[i] + right[i]
*/
public class BestTime3Sol {
	// SOL 1
	public static int maxProfit1(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int len = prices.length;
		int[] left = new int[len];
		int[] right = new int[len];
		
		int min = prices[0];
		left[0] = 0;
		for (int i = 1; i < len; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}
		
		int max = prices[len - 1];
		right[len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}
		
		int rst = 0;
		for (int i = 0; i < len; i++) {
			rst = Math.max(rst, left[i] + right[i]);
		}
		return rst;
    }
	// SOL 2 DP
	public static int maxProfit2(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int rst = 0;
		int len = prices.length;
		int[] left = new int[len];
		
		int min = prices[0];
		left[0] = 0;
		for (int i = 1; i < len; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}
		
		int max = Integer.MIN_VALUE;
		int profit = 0;
		for (int i = len - 1; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			profit = Math.max(profit, max - prices[i]);
			rst = Math.max(rst, profit + left[i]);
		}
		return rst;
	}
	
	public static void main(String[] args) {
		int[] prices = {2, 3, 10, 6, 4, 8, 1};
		System.out.print(maxProfit2(prices));
	}
}
