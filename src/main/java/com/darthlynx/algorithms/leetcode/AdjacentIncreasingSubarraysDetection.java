package com.darthlynx.algorithms.leetcode;

import java.util.List;

// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/
public class AdjacentIncreasingSubarraysDetection {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            int[] increasingSeq = new int[nums.size()];
            increasingSeq[0] = 1;

            // determine the increasing sequences
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) > nums.get(i - 1)) {
                    increasingSeq[i] = increasingSeq[i - 1] + 1;
                } else {
                    increasingSeq[i] = 1;
                }
            }

            // check if both sequences are of size k or more, and adjucent
            for (int i = 0; i < nums.size() - 2 * k + 1; i++) {
                if (increasingSeq[i + k - 1] >= k && increasingSeq[i + 2 * k - 1] >= k) {
                    return true;
                }
            }

            return false;
        }
    }
}
