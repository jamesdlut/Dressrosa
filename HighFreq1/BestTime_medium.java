/*
Best Time to Buy and Sell Stock 
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
/*
变型题:
Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the smaller number in arr[]. 
Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
*/
/*
注意本题目里限定的先后顺序
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        return maxProfit;
    }
}
