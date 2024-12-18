package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
public class FinalPricesWithASpecialDiscountInAShop {

    // Time complexity: O(N^2)
    // Space complexity: O(1)
    class Solution {
        public int[] finalPrices(int[] prices) {

            for (int i = 0; i < prices.length - 1; i++) {
                int discount = 0;
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] <= prices[i]) {
                        discount = prices[j];
                        break;
                    }
                }
                prices[i] = prices[i] - discount;
            }

            return prices;
        }
    }

}
