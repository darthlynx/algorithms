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

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution2 {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int n = nums.length;

            // nums in range [0,100]
            int[] count = new int[101];

            for (int num : nums) {
                count[num]++;
            }

            // use count array as a prefix sum
            for (int i = 1; i < 101; i++) {
                count[i] = count[i] + count[i - 1];
            }

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
            }

            return res;
        }
    }
}
