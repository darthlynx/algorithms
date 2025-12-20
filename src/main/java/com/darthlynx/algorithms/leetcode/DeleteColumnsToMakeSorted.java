package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/delete-columns-to-make-sorted/
public class DeleteColumnsToMakeSorted {

    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    class Solution {
        public int minDeletionSize(String[] strs) {
            int m = strs.length;
            int n = strs[0].length();

            char[][] grid = new char[m][];

            for (int i = 0; i < m; i++) {
                grid[i] = strs[i].toCharArray();
            }

            int num = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 1; i < m; i++) {
                    if (grid[i][j] < grid[i - 1][j]) {
                        num++;
                        break;
                    }
                }
            }

            return num;
        }
    }

    // Time complexity: O(m * n)
    // Space complexity: O(1)
    class Solution2 {
        public int minDeletionSize(String[] strs) {
            int m = strs.length;
            int n = strs[0].length();

            int num = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 1; i < m; i++) {
                    if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                        num++;
                        break;
                    }
                }
            }

            return num;
        }
    }
}
