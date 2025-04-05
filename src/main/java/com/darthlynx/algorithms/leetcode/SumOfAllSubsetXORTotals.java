package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/sum-of-all-subset-xor-totals/
public class SumOfAllSubsetXORTotals {

    // Time complexity: O(2^n)
    // Space complexity: O(n)
    class Solution1 {
        public int subsetXORSum(int[] nums) {
            return XORSum(0, 0, nums);
        }

        private int XORSum(int idx, int currentXOR, int[] nums) {
            if (idx >= nums.length) {
                return currentXOR;
            }
            int withCurrentElement = XORSum(idx + 1, currentXOR ^ nums[idx], nums);
            int withoutCurrentElement = XORSum(idx + 1, currentXOR, nums);
            return withCurrentElement + withoutCurrentElement;
        }
    }

    // Time complexity: O(n * 2^n)
    // Space complexity: O(n * 2^n)
    class Solution2 {
        public int subsetXORSum(int[] nums) {
            int totalSum = 0;

            List<List<Integer>> subsets = new ArrayList<>();
            generateSubsets(0, nums, new ArrayList<>(), subsets);

            for (List<Integer> subset : subsets) {
                int localXOR = 0;
                for (int num : subset) {
                    localXOR = localXOR ^ num;
                }
                totalSum += localXOR;
            }

            return totalSum;
        }

        private void generateSubsets(int idx, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
            if (idx >= nums.length) {
                subsets.add(new ArrayList<>(subset)); // make a copy of current subset
                return;
            }
            // include element
            subset.add(nums[idx]);
            generateSubsets(idx + 1, nums, subset, subsets);
            // do not include element
            subset.remove(subset.size() - 1);
            generateSubsets(idx + 1, nums, subset, subsets);
        }
    }
}
