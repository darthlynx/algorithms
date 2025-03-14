package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
public class MaximumCandiesAllocatedToKChildren {

    // Time complexity: O(N * logM)
    // Space complexity: O(1)
    // where N = candies.length; M = max(candies)
    class Solution {
        public int maximumCandies(int[] candies, long k) {
            int max = 0;
            for (int c : candies) {
                max = Math.max(max, c);
            }

            int good = 0;
            int bad = max + 1;

            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;

                if (canSplit(mid, candies, k)) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }

            return good;
        }

        private boolean canSplit(int candiesPerChild, int[] candies, long k) {
            long children = 0;

            for (int i = 0; i < candies.length; i++) {
                children += candies[i] / candiesPerChild;
            }

            return children >= k;
        }
    }
}
