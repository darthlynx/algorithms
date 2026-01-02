package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
public class NRepeatedElementInSize2NArray {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution1 {
        public int repeatedNTimes(int[] nums) {
            int n = nums.length / 2;

            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == n) {
                    return entry.getKey();
                }
            }

            return -1;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution2 {
        public int repeatedNTimes(int[] nums) {
            Set<Integer> unique = new HashSet<>();
            for (int num : nums) {
                if (unique.contains(num)) {
                    return num;
                }
                unique.add(num);
            }
            return -1;
        }
    }
}
