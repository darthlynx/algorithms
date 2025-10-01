package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/water-bottles/
public class WaterBottles {

    // Time complexity: O(log(numBottles))
    // Space complexity: O(1)
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int num = numBottles;
            while (numBottles >= numExchange) {
                int changed = numBottles / numExchange;
                num += changed;
                int left = numBottles % numExchange;
                numBottles = changed + left;
            }
            return num;
        }
    }
}
