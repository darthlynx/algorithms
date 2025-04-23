package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/count-largest-group/
public class CountLargestGroup {

    // Time complexity: O(n*logn)
    // Space complexity: O(n)
    class Solution {
        public int countLargestGroup(int n) {
            Map<Integer, List<Integer>> groups = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                int sum = digitSum(i);
                groups.computeIfAbsent(sum, x -> new ArrayList<>()).add(i);
            }

            int biggest = 0;
            int count = 1;
            for (List<Integer> group : groups.values()) {
                int size = group.size();
                if (size > biggest) {
                    biggest = size;
                    count = 1;
                } else if (size == biggest) {
                    count++;
                }
            }
            return count;
        }

        private int digitSum(int num) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            return sum;
        }
    }

    // Time complexity: O(n*logn)
    // Space complexity: O(n)
    class Solution2 {
        public int countLargestGroup(int n) {
            // <group, count>
            Map<Integer, Integer> groups = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                int sum = digitSum(i);
                groups.put(sum, groups.getOrDefault(sum, 0) + 1);
            }

            int biggest = 0;
            int count = 1;
            for (int groupSize : groups.values()) {
                if (groupSize > biggest) {
                    biggest = groupSize;
                    count = 1;
                } else if (groupSize == biggest) {
                    count++;
                }
            }
            return count;
        }

        private int digitSum(int num) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            return sum;
        }
    }
}
