package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/flipping-an-image/
public class FlippingTheImage {

    public int[][] flipAndInvertImage(int[][] image) {

        for (int[] row : image) {
            flip(row);
            invert(row);
        }

        return image;
    }

    private void flip(int[] row) {
        int left = 0;
        int right = row.length-1;
        int tmp;
        while (left <= right) {
            tmp = row[left];
            row[left] = row[right];
            row[right] = tmp;
            left++;
            right--;
        }
    }

    private void invert(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = row[i] ^ 1; // convert 1 to 0 and 0 to 1
        }
    }
}
