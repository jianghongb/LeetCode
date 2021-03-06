package com.leetcode.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class MaxProfit121 {

    /**
     * Approach 1: Brute Force
     * Runtime: 431 ms, faster than 5.09% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 41.6 MB, less than 5.31% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] < 0) {
                    continue;
                } else {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    /**
     * Approach 2: One Pass
     * The points of interest are the peaks and valleys in the given graph. We need to find the largest peak following
     * the smallest valley. We can maintain two variables - minprice and maxprofit corresponding to the smallest valley
     * and maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
     *
     * @param prices
     * @return
     */
    public int maxProfitFaster(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
