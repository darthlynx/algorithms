package com.darthlynx.algorithms.leetcode;

import java.util.Random;

// https://leetcode.com/problems/shuffle-an-array/
public class ShuffleAnArray {

    private int[] init;
    private int[] mutated;
    private Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        init = nums;
        mutated = init.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        mutated = init;
        init = init.clone();
        return mutated;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int rightIndex;
        for (int leftIndex = 0; leftIndex < mutated.length; leftIndex++) {
            rightIndex = randomRange(leftIndex, mutated.length);
            swap(leftIndex, rightIndex);
        }
        return mutated;
    }

    private void swap(int i, int j) {
        int temp = mutated[i];
        mutated[i] = mutated[j];
        mutated[j] = temp;
    }

    private int randomRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
