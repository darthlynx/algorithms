package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
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
}
