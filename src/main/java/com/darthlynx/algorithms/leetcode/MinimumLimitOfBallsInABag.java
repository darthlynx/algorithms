package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
public class MinimumLimitOfBallsInABag {

    // Time compexity: O(n * log(k)), where k = max(nums)
    // Space complexity: O(1)
    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int bad = 0;
            int good = getMaxNumber(nums); // max number of balls cannot be bigger than max value in `nums`

            while (good - bad > 1) {
                int mid = bad + (good - bad) / 2;
                // check if distribution is possible with mid value
                if (isPossible(mid, nums, maxOperations)) {
                    good = mid; // if yes, try smaller (because we trying to minimize the result)
                } else {
                    bad = mid; // otherwise, try larger value
                }
            }

            return good;
        }

        private int getMaxNumber(int[] nums) {
            int max = -1;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        private boolean isPossible(int maxBallsInBag, int[] nums, int maxOperations) {
            int operations = 0;
            for (int num : nums) {
                // operations += (int) Math.ceil(num / (double) maxBallsInBag) - 1;
                operations += (num - 1) / maxBallsInBag;
                if (operations > maxOperations) {
                    return false;
                }
            }
            return true;
        }
    }
}
