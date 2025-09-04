package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-closest-person/
public class FindClosestPerson {

    // Time complexity: O(1)
    // Space complexity: O(1)
    class Solution {
        public int findClosest(int x, int y, int z) {
            int xz = Math.abs(x - z);
            int yz = Math.abs(y - z);

            if (xz < yz) {
                return 1;
            } else if (xz > yz) {
                return 2;
            } else {
                return 0;
            }
        }
    }
}
