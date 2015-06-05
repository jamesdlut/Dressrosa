/*
Best Time to Buy and Sell Stock IV 
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
/*
f[i][j] 表示前i天, 至多进行j次交易(也可以不到j次交易), 第i天必须sell的最大获益
g[i][j] 表示前i天, 至多进行j次交易, 第i天sell或者不sell的最大获益
前i天, 至多交易j次, 第i天必须sell = 前i - 1天, 至多交易j次, 第i - 1天必须sell ＋ increase; 前i - 1天, 至多交易j - 1次, 第i - 1天可不sell ＋ increase
前i天, 至多交易j次, 第i天可不交易 = 前i - 1天, 至多交易j次, 第i - 1天可不sell; 前i天, 至多交易j次, 第i天必须sell
*/
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }
        
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        
        int[][] f = new int[prices.length][k + 1];
        int[][] g = new int[prices.length][k + 1];
        
        f[0][0] = g[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            f[0][i] = g[0][i] = 0;
        }
        
        for (int i = 1; i < prices.length; i++) {
            int increase = prices[i] - prices[i - 1];
            f[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                f[i][j] = Math.max(g[i - 1][j - 1] + increase, f[i - 1][j] + increase);
                g[i][j] = Math.max(g[i - 1][j], f[i][j]);
            }
        }
        return g[prices.length - 1][k];
    }
}
