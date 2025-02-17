package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {

    // Time complexity: O(N*logk), where k - max value in the array, n - size of array
    // Space complexity: O(1)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int max = 0;
            for (int pile : piles) {
                max = Math.max(max, pile);
            }

            int bad = 0;
            int good = max + 1;

            while (good - bad > 1) {
                int k = bad + (good - bad) / 2;
                if (canEat(k, piles, h)) {
                    good = k;
                } else {
                    bad = k;
                }
            }

            return good;
        }

        private boolean canEat(int k, int[] piles, int h) {
            long resHours = 0;
            for (int pile : piles) {
                resHours += (pile + k - 1) / k; // ceil(pile / k)
            }
            return resHours <= h;
        }
    }
}
