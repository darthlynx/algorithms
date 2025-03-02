package com.darthlynx.algorithms.leetcode;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
public class MergeTwo2DArraysBySummingValues {

    // Time complexity: O((m+n)log(m+n))
    // Space complexity: O(m+n)
    class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            TreeMap<Integer, Integer> nums = new TreeMap<>();

            for (int[] n : nums1) {
                nums.put(n[0], n[1]);
            }

            for (int[] n : nums2) {
                nums.put(n[0], nums.getOrDefault(n[0], 0) + n[1]);
            }

            int[][] res = new int[nums.size()][2];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
                res[index][0] = entry.getKey();
                res[index][1] = entry.getValue();
                index++;
            }

            return res;
        }
    }
}
