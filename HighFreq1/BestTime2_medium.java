/*
Best Time to Buy and Sell Stock II
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
/*
每次比较当天和前一天的股票值, 如果是上升, 就加上这个差值即可
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int dif = prices[i] - prices[i - 1];
            if (dif > 0) {
                maxProfit += dif;
            }
        }
        return maxProfit;
    }
}
