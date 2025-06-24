package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
public class FindAllKDistantIndicesInAnArray {

    // Time complexity: O(n^2 + n*logn) ~> O(n^2)
    // Space complexity: O(n)
    class Solution1 {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            Set<Integer> indices = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (Math.abs(i - j) <= k && (nums[i] == key || nums[j] == key)) {
                        indices.add(i);
                        indices.add(j);
                    }
                }
            }
            List<Integer> result = new ArrayList<>(indices);
            Collections.sort(result);
            return result;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution2 {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            List<Integer> result = new ArrayList<>();
            int n = nums.length;

            int start = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == key) {
                    int left = Math.max(start, i - k);
                    int right = Math.min(n - 1, i + k);

                    // add all indices in the range
                    for (int j = left; j <= right; j++) {
                        result.add(j);
                    }
                    start = right + 1;
                }
            }

            return result;
        }
    }
}
