package com.darthlynx.algorithms.algocademy.loops;

// https://algocademy.com/app/#problem/pair-count/lang/java/
public class PairCount {

    public int countPairs(int n, int sum) {
        int result = 0;

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (x + y == sum && x <= y) {
                    result++;
                }
            }
        }
        return result;
    }
}
