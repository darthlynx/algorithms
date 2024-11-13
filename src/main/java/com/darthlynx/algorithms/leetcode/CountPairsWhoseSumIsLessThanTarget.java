package com.darthlynx.algorithms.leetcode;

import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
public class CountPairsWhoseSumIsLessThanTarget {

    // Time complexity: O(N * logN)
    // Space complexity: O(logN)
    class Solution {
        public int countPairs(List<Integer> nums, int target) {
            Collections.sort(nums);

            int left = 0;
            int right = nums.size() - 1;
            int count = 0;

            while (right - left > 0) {
                int sum = nums.get(left) + nums.get(right);

                if (sum < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }

            return count;
        }
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    class Solution2 {
        public int countPairs(List<Integer> nums, int target) {
            int count = 0;
    
            for (int i = 0; i < nums.size(); i++) {
                for (int j = i + 1; j < nums.size(); j++) {
                    int sum = nums.get(i) + nums.get(j);
                    if (sum < target) {
                        count++;
                    }
                }
            }
    
            return count;
        }
    }

}
