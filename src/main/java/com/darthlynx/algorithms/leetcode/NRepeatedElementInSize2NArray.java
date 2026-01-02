package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
public class NRepeatedElementInSize2NArray {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution1 {
        public int repeatedNTimes(int[] nums) {
            int n = nums.length / 2;

            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == n) {
                    return entry.getKey();
                }
            }

            return -1;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution2 {
        public int repeatedNTimes(int[] nums) {
            Set<Integer> unique = new HashSet<>();
            for (int num : nums) {
                if (unique.contains(num)) {
                    return num;
                }
                unique.add(num);
            }
            return -1;
        }
    }

    // this solution is not correct. It passes all leetcode tests but can fail for some edge cases
    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution3 {
        public int repeatedNTimes(int[] nums) {
            // check first 3 elements to find the repeated one
            if (nums.length >= 3 && (nums[0] == nums[1] || nums[0] == nums[2])) {
                return nums[0];
            }

            // apply Boyer-Moore Voting Algorithm for nums.length - 1 elements
            int count = 0;
            int elem = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    count++;
                    elem = nums[i];
                } else if (count > 0 && elem == nums[i]) {
                    return elem;
                } else {
                    count--;
                }
            }

            return elem;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution4 {
        public int repeatedNTimes(int[] nums) {
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                    return nums[i];
                }
            }
            return nums[nums.length - 1];
        }
    }
}
