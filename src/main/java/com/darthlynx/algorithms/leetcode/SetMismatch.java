package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/set-mismatch/
public class SetMismatch {

    class Solution {
        public int[] findErrorNums(int[] nums) {
            Arrays.sort(nums);
            Set<Integer> seen = new HashSet<>();
            int repeated = 0;
            int missing = 0;

            for (int i = 0; i < nums.length; i++) {
                if (seen.contains(nums[i])) {
                    repeated = nums[i];
                } else {
                    seen.add(nums[i]);
                }
                if (!seen.contains(i + 1)) {
                    missing = i + 1;
                }
            }
            return new int[] { repeated, missing };
        }
    }
}
