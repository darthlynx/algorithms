package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/
public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    class Solution1 {
        public int minimumOperations(int[] nums) {
            int ops = 0;
            for (int i = 0; i < nums.length; i += 3) {
                if (isUnique(i, nums)) {
                    return ops;
                }
                ops++;
            }
            return ops;
        }

        private boolean isUnique(int start, int[] nums) {
            Set<Integer> dups = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (dups.contains(nums[i])) {
                    return false;
                }
                dups.add(nums[i]);
            }
            return true;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution2 {
        public int minimumOperations(int[] nums) {
            Set<Integer> dups = new HashSet<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                if (dups.contains(nums[i])) {
                    return i / 3 + 1;
                } else {
                    dups.add(nums[i]);
                }
            }
            return 0;
        }
    }
}
