package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-time-to-repair-cars/
public class MinimumTimeToRepairCars {

    // Time complexity: O(N*logM)
    // Space complexity: O(1)
    // where N = ranks.length(), M = Long.MAX_VALUE;
    class Solution {
        public long repairCars(int[] ranks, int cars) {
            long bad = 0;
            long good = Long.MAX_VALUE;

            while (good - bad > 1) {
                long mid = bad + (good - bad) / 2;
                if (canRepair(ranks, cars, mid)) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }

            return good;
        }

        private boolean canRepair(int[] ranks, int cars, long time) {
            int repairedCars = 0;
            for (int rank : ranks) {
                repairedCars += (int) Math.floor(Math.sqrt((double) time / rank));
                if (repairedCars >= cars) {
                    return true;
                }
            }
            return repairedCars >= cars;
        }
    }
}
