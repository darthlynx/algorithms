package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> current = new ArrayList<>();
            dfs(0, current, 0, target, result, candidates);

            return result;
        }

        private void dfs(int i, List<Integer> current, int curSum, int target, List<List<Integer>> result, int[] candidates) {

            if (curSum == target) {
                result.add(new ArrayList<>(current));
                return;
            }

            if (i >= candidates.length || curSum > target) {
                return;
            }

            // include current number:
            current.add(candidates[i]);
            dfs(i, current, curSum + candidates[i], target, result, candidates);

            // do not include current number:
            current.remove(current.size()-1); // remove number which we just added
            dfs(i+1, current, curSum, target, result, candidates);
        }
    }
}
