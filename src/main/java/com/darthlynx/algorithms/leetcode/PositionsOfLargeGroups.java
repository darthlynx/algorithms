package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/positions-of-large-groups/
public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();

        int left = 0;
        char previous = s.charAt(left);
        int counter = 1;
        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right) == previous) {
                counter++;
            } else {
                if (counter >= 3) {
                    result.add(List.of(left, right-1));
                }
                counter = 1;
                left = right;
            }
            previous = s.charAt(right);
        }
        if (counter >= 3) {
            result.add(List.of(left, s.length() - 1));
        }

        return result;
    }
}
