package com.darthlynx.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/partition-array-according-to-given-pivot/
public class PartitionArrayAccordingToGivenPivot {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution1 {
        public int[] pivotArray(int[] nums, int pivot) {
            Queue<Integer> lessThanPivot = new LinkedList<>();
            Queue<Integer> greaterThanPivot = new LinkedList<>();

            for (int num : nums) {
                if (num < pivot) {
                    lessThanPivot.offer(num);
                } else if (num > pivot) {
                    greaterThanPivot.offer(num);
                }
            }

            int[] result = new int[nums.length];
            int pivotSize = nums.length - (lessThanPivot.size() + greaterThanPivot.size());

            int index = 0;
            while (!lessThanPivot.isEmpty()) {
                result[index] = lessThanPivot.poll();
                index++;
            }
            for (int i = index; i < index + pivotSize; i++) {
                result[i] = pivot;
            }
            index = index + pivotSize;
            while (!greaterThanPivot.isEmpty()) {
                result[index] = greaterThanPivot.poll();
                index++;
            }

            return result;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution2 {
        public int[] pivotArray(int[] nums, int pivot) {
            int less = 0;
            int equal = 0;

            for (int num : nums) {
                if (num < pivot) {
                    less++;
                } else if (num == pivot) {
                    equal++;
                }
            }

            int lessIndex = 0;
            int equalIndex = lessIndex + less;
            int greaterIndex = equalIndex + equal;

            int[] result = new int[nums.length];
            for (int num : nums) {
                if (num < pivot) {
                    result[lessIndex] = num;
                    lessIndex++;
                } else if (num == pivot) {
                    result[equalIndex] = num;
                    equalIndex++;
                } else {
                    result[greaterIndex] = num;
                    greaterIndex++;
                }
            }

            return result;
        }
    }
}
