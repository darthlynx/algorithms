package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/candy/
public class Candy {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];
            Arrays.fill(candies, 1);

            // left to right pass to give more candies to children with bigger rating
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }

            // right to left pass to make sure that kids with lower rating
            // get less candies
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    // max between current number of candies
                    // and number of candies for the i+1 kid with less rating
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }

            int res = 0;
            for (int c : candies) {
                res += c;
            }

            return res;
        }
    }
}
