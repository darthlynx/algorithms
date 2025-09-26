package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class ThreeSum {

    // Time complexity: O(n^2)
    // Space complexity: O(k), where k = result.size();
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) { // skip duplicate i
                    continue;
                }
                // break early because the array is sorted, so all future numbers will also be positive
                if (nums[i] > 0) {
                    break;
                }

                int left = i + 1, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        result.add(List.of(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        // skip duplicates for left and right
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
            return result;
        }
    }

}
