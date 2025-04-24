package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/count-complete-subarrays-in-an-array/
public class CountCompleteSubarraysInAnArray {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int countCompleteSubarrays(int[] nums) {
            Set<Integer> distinct = new HashSet<>();
            for (int num : nums) {
                distinct.add(num);
            }
            int target = distinct.size();

            Map<Integer, Integer> map = new HashMap<>();
            int incompleteCount = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                while (map.size() == target) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                    left++;
                }
                // Here, map.size() < target, so window [left, right] is incomplete
                incompleteCount += right - left + 1;
            }

            int n = nums.length;
            int allSubarrays = n * (n + 1) / 2;

            return allSubarrays - incompleteCount;
        }
    }
}
