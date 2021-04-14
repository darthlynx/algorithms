package com.darthlynx.algorithms.leetcode;

public class RangeSumQueryMutable {

    static class NumArray {

        int[] segmentTree;
        int n;

        public NumArray(int[] nums) {
            n = nums.length - 1;
            segmentTree = new int[nums.length * 4];

            build(nums, 0, n, 1);
        }

        public void build(int[] nums, int tL, int tR, int stIndex) {
            if (tL == tR) {
                segmentTree[stIndex] = nums[tL];
                return;
            }
            int tm = (tR - tL) / 2;
            build(nums, tL, tm, stIndex * 2);
            build(nums, tm + 1, tR, stIndex * 2 + 1);

            segmentTree[stIndex] = segmentTree[stIndex * 2] + segmentTree[stIndex * 2 + 1];
        }

        public void update(int index, int val) {
            update(0, n, 1, index, val);
        }

        private void update(int tL, int tR, int stIndex, int index, int val) {
            if (tL == tR) {
                segmentTree[stIndex] = val;
                return;
            }
            int tm = (tR - tL) / 2;
            if (index <= tm) {
                update(tL, tm, stIndex * 2, index, val);
            } else {
                update(tm + 1, tR, stIndex * 2 + 1, index, val);
            }
            segmentTree[stIndex] = segmentTree[stIndex * 2] + segmentTree[stIndex * 2 + 1];
        }

        public int sumRange(int left, int right) {
            return sum(0, n, 1, left, right);
        }

        private int sum(int tL, int tR, int stIndex, int left, int right) {
            if (tL == left && tR == right) {
                return segmentTree[stIndex];
            }
            if (tL > right || tR < left) {
                return 0;
            }
            int tm = (tR - tL) / 2;
            return sum(tL, tm, stIndex * 2, left, Math.min(right, tm)) +
                    sum(tm+1, tR, stIndex*2 + 1, Math.max(left, tm+1), right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray obj = new NumArray(nums);
        obj.update(0,2);
        int param_2 = obj.sumRange(1,2);
        System.out.println(param_2);
    }
}
