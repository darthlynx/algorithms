package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-lucky-integer-in-an-array/
public class FindLuckyIntegerInAnArray {

    // Time complexity: O(N * logN)
    // Space complexity: O(N)
    class Solution1 {
        public int findLucky(int[] arr) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : arr) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            List<Integer> res = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getKey() == entry.getValue()) {
                    res.add(entry.getKey());
                }
            }

            Collections.sort(res);

            return res.isEmpty() ? -1 : res.get(res.size() - 1);
        }
    }

    // Time complexity: O(N)
    // Space complexity: O(N)
    class Solution2 {
        public int findLucky(int[] arr) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : arr) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            int res = -1;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getKey() == entry.getValue()) {
                    res = Math.max(res, entry.getKey());
                }
            }

            return res;
        }
    }
}
