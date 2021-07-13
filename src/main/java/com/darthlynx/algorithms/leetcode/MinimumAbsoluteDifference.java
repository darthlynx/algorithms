package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/minimum-absolute-difference/
public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> pairs = new ArrayList<>();

        Arrays.sort(arr);
        int minDiff = minAbsDifference(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int delta = arr[i+1] - arr[i];
            if (delta == minDiff) {
                pairs.add(List.of(arr[i], arr[i+1]));
            }
        }
        return pairs;
    }

    private int minAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i+1] - arr[i]);
        }
        return min;
    }
}
