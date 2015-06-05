/*
Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
/*
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
