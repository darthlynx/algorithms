package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/closest-prime-numbers-in-range/
public class ClosestPrimeNumbersInRange {

    // Time complexity: O(N*log(logN)), where N == right
    // Space complexity: O(N)
    class Solution {
        public int[] closestPrimes(int left, int right) {
            List<Integer> primes = getPrimesInRange(left, right);

            int num1 = -1;
            int num2 = -1;
            int diff = Integer.MAX_VALUE;
            for (int i = 1; i < primes.size(); i++) {
                int currDiff = primes.get(i) - primes.get(i - 1);
                if (currDiff < diff) {
                    diff = currDiff;
                    num1 = primes.get(i - 1);
                    num2 = primes.get(i);
                }
            }

            return new int[] { num1, num2 };
        }

        // Sieve of Eratosthenes approach
        private List<Integer> getPrimesInRange(int left, int right) {
            List<Integer> primes = new ArrayList<>();
            boolean[] isPrime = new boolean[right + 1];
            Arrays.fill(isPrime, true);
            isPrime[1] = false; // 1 is not a prime number

            for (int i = 2; i * i <= right; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= right; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            for (int i = left; i <= right; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                }
            }

            return primes;
        }
    }
}
