package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    // Time complexity: O(n log n)
    // Space complexity: O(n)
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int n = nums.length;

            List<int[]> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pairs.add(new int[] { nums[i], i });
            }

            Collections.sort(pairs, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });

            int[] res = new int[n];
            for (int i = 1; i < n; i++) {
                int[] pair = pairs.get(i);
                int[] prev = pairs.get(i - 1);
                if (pair[0] == prev[0]) {
                    res[pair[1]] = res[prev[1]];
                } else {
                    res[pair[1]] = i;
                }
            }

            return res;
        }
    }
}
