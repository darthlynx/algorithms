package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalsTriange {

    // Time complexity: O(n^2)
    // Space complexity: O(n^2)
    class Solution {

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        int current = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                        row.add(current);
                    }
                }
                res.add(row);
            }
            return res;
        }
    }

}
