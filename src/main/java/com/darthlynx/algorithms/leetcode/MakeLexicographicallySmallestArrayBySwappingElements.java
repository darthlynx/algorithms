package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
public class MakeLexicographicallySmallestArrayBySwappingElements {

    // Time complexity: O(N * logN)
    // Space complexity: O(N)
    class Solution {
        // idea is to form the groups of numbers based on the Math.abs(a - b) <= limit
        // To do that efficiently, we need to sort the original array and then traverse through each number
        // and if difference between last number and current number is bigger than limit,
        // we need to create a new group.
        // Once groups are formed, we create a result array
        // where we put the number into position based on its group
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);

            Map<Integer, Integer> numToGroup = new HashMap<>();
            List<LinkedList<Integer>> groups = new ArrayList<>();

            for (int num : sorted) {
                if (numToGroup.isEmpty()
                        // diff between current and last is bigger than limit.
                        // last element located in the last position of the last added group
                        || Math.abs(num - groups.getLast().getLast()) > limit) {
                    groups.add(new LinkedList<>()); 
                }
                groups.getLast().add(num);
                numToGroup.put(num, groups.size() - 1);
            }

            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int group = numToGroup.get(num);
                res[i] = groups.get(group).pop();
            }
            return res;
        }
    }
}
