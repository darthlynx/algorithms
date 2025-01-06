package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    class Solution {
        public int[] minOperations(String boxes) {
            int n = boxes.length();
            int[] bxs = new int[n];
            for (int i = 0; i < n; i++) {
                bxs[i] = boxes.charAt(i) - '0';
            }
    
            int[] res = new int[n];
    
            for (int i = 0; i < n; i++) {
                int moves = 0;
                for (int j = 0; j < i; j++) {
                    moves += bxs[j] * (i - j);
                }
                for (int j = i + 1; j < n; j++) {
                    moves += bxs[j] * (j - i);
                }
                res[i] = moves;
            }
    
            return res;
        }
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    class Solution2 {
        public int[] minOperations(String boxes) {
            int n = boxes.length();
            int[] res = new int[n];
    
            for (int i = 0; i < n; i++) {
                int moves = 0;
                for (int j = 0; j < i; j++) {
                    moves += getNumOfBalls(j, boxes) * (i - j);
                }
                for (int j = i + 1; j < n; j++) {
                    moves += getNumOfBalls(j, boxes) * (j - i);
                }
                res[i] = moves;
            }
    
            return res;
        }
    
        private int getNumOfBalls(int index, String s) {
            return s.charAt(index) - '0';
        }
    }
}
