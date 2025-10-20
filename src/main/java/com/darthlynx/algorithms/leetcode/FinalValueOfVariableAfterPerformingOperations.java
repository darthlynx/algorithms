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
}
