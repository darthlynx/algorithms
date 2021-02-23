package com.darthlynx.algorithms.leetcode;

public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};

        System.out.println(new BestTimeToBuyAndSellStocks().maxProfit(prices));
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock
    public int maxProfit(int[] prices) {
        var minPrice = Integer.MAX_VALUE;
        var maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
