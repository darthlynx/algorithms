package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
public class TheTwoSneakyNumbersOfDigitville {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            int[] result = new int[2];
            Arrays.fill(result, -1);
            int index = 0;

            Set<Integer> visited = new HashSet<>();

            for (int num : nums) {
                if (!visited.add(num)) { // add() returns false if element already appeared in the set
                    result[index++] = num;
                    if (index > 1) {
                        break;
                    }
                }
            }

            return result;
        }
    }
}
