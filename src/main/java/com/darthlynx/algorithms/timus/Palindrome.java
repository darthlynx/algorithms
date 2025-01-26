package com.darthlynx.algorithms.timus;

import java.util.Scanner;

// https://acm.timus.ru/problem.aspx?space=1&num=1297
public class Palindrome {

    private static final int base = 53;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String init = s.next();

        long[] powers = getPowersOfBase(base);
        long[] hashes = calculateHashes(init, powers);

        int maxLength = 0;
        int maxL = 0;
        int maxR = 0;

        for (int r = init.length() - 1; r >= 0; r--) {
            long hash = 0L;
            for (int l = r; l >= 0; l--) {
                hash += init.charAt(l) * powers[r-l];
                if (hashes[getPosition(l, r)] == hash) {
                    int length = (r - l) + 1;
                    if (length >= maxLength) {
                        maxLength = length;
                        maxL = l;
                        maxR = r;
                    }
                }
            }
        }

        System.out.println(init.substring(maxL, maxR+1));
    }

    private static int getPosition(int l, int r) {
        return l * 1001 + r;
    }

    private static long[] getPowersOfBase(int base) {
        long[] powers = new long[1000];
        long res = 1;
        for (int i = 0; i < powers.length; i++) {
            powers[i] = res;
            res *= base;
        }
        return powers;
    }

    private static long[] calculateHashes(String init, long[] powers) {
        long[] hashes = new long[1100000];
        for (int l = 0; l < init.length(); l++) {
            long hash = 0L;
            for (int r = l; r < init.length(); r++) {
                hash += (long) init.charAt(r) * powers[r-l];
                hashes[getPosition(l, r)] = hash;
            }
        }
        return hashes;
    }

}
