package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStocksTest {

    @Test
    public void testMaxProfit() {
        var instance = new BestTimeToBuyAndSellStocks();
        int[] prices = {7,1,5,3,6,4};
        var expectedResult = 5;
        assertEquals(expectedResult, instance.maxProfit(prices));
    }

}