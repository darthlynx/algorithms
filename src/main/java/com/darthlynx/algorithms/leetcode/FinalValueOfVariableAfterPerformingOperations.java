package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
public class FinalValueOfVariableAfterPerformingOperations {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int x = 0;
            for (String op : operations) {
                if (op.startsWith("-")) {
                    --x;
                } else if (op.startsWith("+")) {
                    ++x;
                } else if (op.endsWith("-")) {
                    x--;
                } else {
                    x++;
                }
            }
            return x;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution2 {
        public int finalValueAfterOperations(String[] operations) {
            int x = 0;
            // X++ or ++X will have '+' at index 1
            // X-- or --X will have '-' at index 1
            for (String op : operations) {
                if (op.charAt(1) == '+') {
                    x++;
                } else {
                    x--;
                }
            }
            return x;
        }
    }
}
