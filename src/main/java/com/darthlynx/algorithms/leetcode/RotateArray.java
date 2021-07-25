package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/rotate-array/
public class RotateArray {

    // let's assume that we have nums = {1,2,3} and k = 2
    // thus, iterations will be the next:
    // 1) {3,1,2}
    // 2) {2,3,1}
    // we are using doubled copy of the array here
    // in this case doubled array will be the next:
    // {1,2,3,1,2,3}
    // and if you subtract `doubled.length - (k+1)` you will find the end of the shift array
    // {1,2,3,1,2,3}
    //    ^ ^ ^ _ _ <-

    // Time complexity: O(n)
    // Space complexity: O(2*n) == O(n)
    public void rotate(int[] nums, int k) {

        if (nums.length == 1 || k == 0) {
            return;
        }

        // if k > nums.length, it is enough to make k % nums.length operations to get the same result
        if (k > nums.length) {
            k = k % nums.length;
        }

        int[] doubled = new int[nums.length*2];

        System.arraycopy(nums, 0, doubled, 0, nums.length);
        System.arraycopy(nums, 0, doubled, nums.length, nums.length);

        for (int i = doubled.length - (k+1), j = nums.length-1; j >= 0; i--, j--) {
            nums[j] = doubled[i];
        }

    }
}
