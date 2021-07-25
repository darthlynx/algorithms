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
    public void rotate2(int[] nums, int k) {

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


    // In this approach we rotate the parts of array using the next algorithm
    // 1) rotate a part of array from `nums.length - k` to `nums.length-1`
    // 2) rotate a part from the beginning to the `nums.length - k - 1`
    // 3) rotate entire array

    // e.g.
    // given array {1,2,3,4,5} and k = 2
    // first of all we rotate next part:
    // {1,2,3,4,5}  -> {1,2,3,5,4}
    //        ^ ^
    // then we rotate the other part:
    // {1,2,3,5,4}  -> {3,2,1,5,4}
    //  ^ ^ ^
    // and after that we rotate entire array:
    // {4,5,1,2,3}

    // Time complexity: O(n)
    // Space complexity: O(1)
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        int length = nums.length;

        rotatePart(nums, length - k, length-1);
        rotatePart(nums, 0, length - k - 1);
        rotatePart(nums, 0, length-1);
    }

    private void rotatePart(int[] arr, int left, int right) {
        while (left <= right) {
            swap(arr, left, right);
            left++; right--;
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
