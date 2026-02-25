package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
public class SortIntegersByTheNumberOfOneBits {

    // Time complexity: O(n log n)
    // Space complexity: O(n)
    class Solution {
        public int[] sortByBits(int[] arr) {
            List<int[]> freqs = new ArrayList<>();

            for (int num : arr) {
                freqs.add(new int[] { num, calculateOnes(num) });
            }

            Collections.sort(freqs, (a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });

            int[] res = new int[arr.length];
            for (int i = 0; i < freqs.size(); i++) {
                res[i] = freqs.get(i)[0];
            }
            return res;
        }

        private int calculateOnes(int n) {
            String s = Integer.toBinaryString(n);
            int count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    count++;
                }
            }
            return count;
        }
    }

    // Time complexity: O(n log n)
    // Space complexity: O(n)
    class Solution2 {
        public int[] sortByBits(int[] arr) {
            List<Integer> list = new ArrayList<>();

            for (int num : arr) {
                list.add(num);
            }

            list.sort((a, b) -> {
                int aBits = Integer.bitCount(a);
                int bBits = Integer.bitCount(b);
                if (aBits == bBits) {
                    return Integer.compare(a, b);
                }
                return Integer.compare(aBits, bBits);
            });

            int[] res = new int[arr.length];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    // Time complexity: O(n + k log k), where k is the maximum number of elements in a bucket
    // Space complexity: O(n)
    class Solution3 {
        public int[] sortByBits(int[] arr) {
            // implementing bucket sort

            // number of buckets == 14, because arr[i] <= 10_000
            // and this number fits into 14 bits
            // in worse case scenario, number will take all 14 bits ('1'-s)
            int[][] buckets = new int[15][];
            // insert position for the bucket
            int[] insertPos = new int[15];

            // initiate each bucket with size 4 (could be any)
            // bucket array size will grow if needed
            for (int i = 0; i < 15; i++) {
                buckets[i] = new int[4];
            }

            // put each number into the right bucket based on the bit count
            for (int num : arr) {
                int bitCount = Integer.bitCount(num);

                // if bucket is full, double the capacity, copy the data
                if (buckets[bitCount].length == insertPos[bitCount]) {
                    buckets[bitCount] = Arrays.copyOf(buckets[bitCount], buckets[bitCount].length * 2);
                }
                // put number into the bucket
                buckets[bitCount][insertPos[bitCount]] = num;
                // increment the position in the bucket
                insertPos[bitCount]++;
            }

            int[] res = new int[arr.length];
            int idx = 0;

            // iterate over the buckets, concat the results
            for (int i = 0; i < 15; i++) {
                int len = insertPos[i];
                if (len == 0) { // if no numbers in the bucket
                    continue;
                }

                // sort elements in the bucket.
                // since capacity might be bigger than actual numbers
                // we sort only part with real numbers
                Arrays.sort(buckets[i], 0, len);

                // add elements from the bucket to the result list
                for (int j = 0; j < len; j++) {
                    res[idx] = buckets[i][j];
                    idx++;
                }
            }
            return res;
        }
    }
}
