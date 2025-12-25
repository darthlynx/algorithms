package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindAllNumbersDisappearedInAnArray {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            boolean[] visited = new boolean[nums.length + 1];

            for (int num : nums) {
                visited[num] = true;
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 1; i < visited.length; i++) {
                if (!visited[i]) {
                    result.add(i);
                }
            }
            return result;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution2 {
        public List<Integer> findDisappearedNumbers(int[] nums) {

            for (int i = 0; i < nums.length; i++) {
                int idx = Math.abs(nums[i]) - 1;
                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx]; // make negative to mark as visited
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
}
