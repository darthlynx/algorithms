package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/make-array-elements-equal-to-zero/
public class MakeArrayElementsEqualToZero {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int countValidSelections(int[] nums) {
            int totalSum = 0;
            for (int num : nums) {
                totalSum += num;
            }

            int result = 0;
            int currSum = 0;
            for (int num : nums) {
                if (num == 0) {
                    if (currSum - totalSum >= 0 && currSum - totalSum <= 1) {
                        result++;
                    }
                    if (totalSum - currSum >= 0 && totalSum - currSum <= 1) {
                        result++;
                    }
                } else {
                    currSum += num;
                    totalSum -= num;
                }
            }

            return result;
        }
    }
}
