package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
public class CountHillsAndValleysInAnArray {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int countHillValley(int[] nums) {
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (arr.size() == 0 || arr.size() != 0 && arr.get(arr.size() - 1) != nums[i]) {
                    arr.add(nums[i]);
                }
            }

            int count = 0;
            for (int i = 1; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i - 1) && arr.get(i) > arr.get(i + 1)
                        || arr.get(i) < arr.get(i - 1) && arr.get(i) < arr.get(i + 1)) {
                    count++;
                }
            }

            return count;
        }
    }
}
