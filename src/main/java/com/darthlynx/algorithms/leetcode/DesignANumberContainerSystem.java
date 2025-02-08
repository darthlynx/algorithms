package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// https://leetcode.com/problems/design-a-number-container-system/
public class DesignANumberContainerSystem {

    // Space complexity: O(n)
    class NumberContainers {
        private Map<Integer, Integer> indexToNumber;
        private Map<Integer, TreeSet<Integer>> numToIndex;

        public NumberContainers() {
            indexToNumber = new HashMap<>();
            numToIndex = new HashMap<>();
        }

        // Time complexity: O(logn)
        public void change(int index, int number) {
            if (indexToNumber.containsKey(index)) {
                int oldNumber = indexToNumber.get(index);
                numToIndex.get(oldNumber).remove(index);
            }
            indexToNumber.put(index, number);
            numToIndex.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
        }

        // Time complexity: O(1)
        public int find(int number) {
            if (numToIndex.containsKey(number) && numToIndex.get(number).size() > 0) {
                return numToIndex.get(number).getFirst(); // get smallest index
            }
            return -1;
        }
    }

    /**
     * Your NumberContainers object will be instantiated and called as such:
     * NumberContainers obj = new NumberContainers();
     * obj.change(index,number);
     * int param_2 = obj.find(number);
     */
}
