package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> subset = new ArrayList<>();
            dfs(nums, 0, subset, res);

            return res;
        }

        private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
            if (index >= nums.length) {
                res.add(new ArrayList<>(subset));
                return;
            }

            // append current number
            subset.add(nums[index]);
            dfs(nums, index+1, subset, res);

            // do not append number
            subset.remove(subset.size()-1);
            dfs(nums, index+1, subset, res);
        }
    }
}
