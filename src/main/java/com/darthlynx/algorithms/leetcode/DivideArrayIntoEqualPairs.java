package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/divide-array-into-equal-pairs/
public class DivideArrayIntoEqualPairs {

    // Time complexity: O(N)
    // Space complexity: O(N)
    class Solution {
        public boolean divideArray(int[] nums) {
            int[] freq = new int[501]; // range of numbers is limited
            for (int num : nums) {
                freq[num]++;
            }

            for (int f : freq) {
                if (f % 2 > 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
