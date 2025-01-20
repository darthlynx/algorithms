package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-completely-painted-row-or-column/
public class FirstCompletelyPaintedRowOrColumn {

    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            int[] rowFreq = new int[m];
            int[] colFreq = new int[n];

            Map<Integer, int[]> map = new HashMap<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map.put(mat[i][j], new int[] { i, j });
                }
            }

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                int[] coordinates = map.get(num);
                int x = coordinates[0];
                int y = coordinates[1];
                rowFreq[x]++;
                if (rowFreq[x] == n) {
                    return i;
                }
                colFreq[y]++;
                if (colFreq[y] == m) {
                    return i;
                }
            }

            return -1; // should never happen
        }
    }
}
