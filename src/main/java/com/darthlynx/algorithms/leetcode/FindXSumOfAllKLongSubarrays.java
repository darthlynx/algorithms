package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays/
public class FindXSumOfAllKLongSubarrays {

    // Time complexity: O(n * k log k)
    // Space complexity: O(k) excluding the output array
    class Solution {
        public int[] findXSum(int[] nums, int k, int x) {
            int m = nums.length - k + 1;
            int[] result = new int[m];
            for (int i = 0; i < m; i++) {
                result[i] = xSum(nums, i, k, x);
            }
            return result;
        }

        private int xSum(int[] nums, int start, int k, int x) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = start; i < start + k; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            List<int[]> entries = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                entries.add(new int[] { entry.getKey(), entry.getValue() });
            }
            Collections.sort(entries, (e1, e2) -> {
                if (e1[1] == e2[1]) {
                    return Integer.compare(e2[0], e1[0]);
                }
                return Integer.compare(e2[1], e1[1]);
            });

            int xSum = 0;
            for (int i = 0; i < x && i < entries.size(); i++) {
                int[] entry = entries.get(i);
                xSum += entry[0] * entry[1];
            }

            return xSum;
        }
    }
}
