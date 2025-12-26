package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-penalty-for-a-shop/
public class MinimumPenaltyForAShop {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int bestClosingTime(String customers) {
            int n = customers.length();
            int[] ns = new int[n + 1];
            int[] ys = new int[n + 1];

            // ns[i] = number of 'N' in [0, i)
            for (int i = 0; i < n; i++) {
                ns[i + 1] = ns[i] + (customers.charAt(i) == 'N' ? 1 : 0);
            }

            // ys[i] = number of 'Y' in [i, n)
            for (int i = n - 1; i >= 0; i--) {
                ys[i] = ys[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
            }

            int minHour = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                int currentPenalty = ns[i] + ys[i];
                if (currentPenalty < min) {
                    min = currentPenalty;
                    minHour = i;
                }
            }

            return minHour;
        }
    }
}
