package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
    
            int idx = nums1.length - 1; // insertion index
    
            while (i >= 0 || j >= 0) {
                if ((i >= 0 && j >= 0) && nums1[i] > nums2[j] || j < 0) {
                    nums1[idx] = nums1[i];
                    i--;
                } else {
                    nums1[idx] = nums2[j];
                    j--;
                }
                idx--;
            }
        }
    }

}
