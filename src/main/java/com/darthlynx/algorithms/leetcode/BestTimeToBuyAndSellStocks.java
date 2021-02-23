package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestTimeToBuyAndSellStocks {

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

    @Test
    public void testMaxProfit() {
        var instance = new BestTimeToBuyAndSellStocks();
        int[] prices = new int[]{7,1,5,3,6,4};
        var expectedResult = 5;
        assertEquals(expectedResult, instance.maxProfit(prices));
    }
}
