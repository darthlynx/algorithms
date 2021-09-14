package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/permutations/
public class Permutations {

    private List<List<Integer>> permutations = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(0, nums);
        return permutations;
    }

    private void backtrack(int current, int[] nums) {
        if (current == nums.length) {
            permutations.add(arrayToList(nums));
            return;
        }

        for (int i = current; i < nums.length; i++) {
            swap(i, current, nums);
            backtrack(current+1, nums);
            swap(i, current, nums);
        }

    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

//    private List<Integer> arrayToList(int[] nums) {
//        return Arrays.stream(nums).boxed().collect(Collectors.toList());
//    }
    private List<Integer> arrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) {
            list.add(i);
        }
        return list;
    }
}
