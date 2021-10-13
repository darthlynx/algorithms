package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/sqrtx/
public class Sqrt {

    public int mySqrt(int x) {
        return binarySearch(x);
    }

    private int binarySearch(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int left = 0;
        int right = n;

        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;

            if (mid >= n/mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left == n / left ? left : left-1;
    }
}
