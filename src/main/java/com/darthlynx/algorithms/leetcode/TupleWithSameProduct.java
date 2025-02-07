package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/tuple-with-same-product/
public class TupleWithSameProduct {

    // Time complexity: O(n^3 + nlogn) ~> O(n^3)
    // Space complexity: O(n)
    class Solution {
        public int tupleSameProduct(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums); // to ensure that 'c' and 'd' are always between 'a' and 'b'

            int count = 0;
            for (int a = 0; a < n; a++) {
                for (int b = n - 1; b >= 0; b--) {
                    int ab = nums[a] * nums[b];
                    Set<Integer> values = new HashSet<>();
                    for (int c = a + 1; c < b; c++) {
                        if (ab % nums[c] == 0) {
                            int d = ab / nums[c];

                            if (values.contains(d)) {
                                count += 8; // 4 distinct digits form 8 unique combinations
                            }
                            values.add(nums[c]);
                        }
                    }
                }
            }

            return count;
        }
    }
}
