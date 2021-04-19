package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }

        int[] nums3 = Arrays.copyOf(nums1, nums1.length);

        int i = 0;
        int j = 0;
        int k = 0;

        while (k < nums1.length || i < m || j < n ) {
            if (i > m-1) {
                nums1[k++] = nums2[j++];
            } else if (j > n-1) {
                nums1[k++] = nums2[i++];
            } else if (nums3[i] >= nums2[j]) {
                nums1[k++] = nums2[j++];
            } else {
                nums1[k++] = nums3[i++];
            }
        }
    }
}
