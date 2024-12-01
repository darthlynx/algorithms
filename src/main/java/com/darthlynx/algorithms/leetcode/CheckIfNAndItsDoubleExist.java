package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/check-if-n-and-its-double-exist/
public class CheckIfNAndItsDoubleExist {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();

            for (int i : arr) {
                if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                    return true;
                } else {
                    set.add(i);
                }
            }
            
            return false;
        }
    }

}
