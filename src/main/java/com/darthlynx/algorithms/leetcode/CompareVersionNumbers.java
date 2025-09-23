package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/compare-version-numbers/
public class CompareVersionNumbers {

    // Time complexity: O(n + m)
    // Space complexity: O(n + m)
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] nums1 = version1.split("\\.");
            String[] nums2 = version2.split("\\.");

            int result = 0;
            int p1 = 0, p2 = 0;
            while (result == 0) {
                if (p1 < nums1.length && p2 < nums2.length) {
                    result = Integer.compare(Integer.valueOf(nums1[p1]), Integer.valueOf(nums2[p2]));
                    p1++;
                    p2++;
                } else if (p1 < nums1.length && p2 >= nums2.length) {
                    result = Integer.compare(Integer.valueOf(nums1[p1]), 0);
                    p1++;
                } else if (p2 < nums2.length && p1 >= nums1.length) {
                    result = Integer.compare(0, Integer.valueOf(nums2[p2]));
                    p2++;
                } else {
                    break;
                }
            }
            return result;
        }
    }
}
