package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;

        int pivot;

        while (left < right) {
            // need to use this kind of pivot calculation to avoid the Integer overflow
            // https://en.wikipedia.org/wiki/Binary_search_algorithm#Implementation_issues
            pivot = left + (right - left) / 2;

            if (isBadVersion(pivot)) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }

        return left;
    }

    boolean isBadVersion(int version) {
        // some internal logic here
        return false;
    }
}
