package com.darthlynx.algorithms.timus;

import java.util.Scanner;

// https://acm.timus.ru/problem.aspx?space=1&num=1423
public class StringTale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();

        String res = t + " " + s + s;

        int z = zFunc(res, n);
        if (z < 0) {
            System.out.println(z);
        } else {
            int x = 2 * n - z + 1;
            System.out.println( x == n ? 0 : x); // 0 ≤ X < N
        }

    }

    static int zFunc(String s, int size) {
        int n = s.length();
        int[] z = new int[n];
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1, l = 0, r = 0; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i+z[i] < n && s.charAt(z[i]) == s.charAt(i+z[i])) {
                ++z[i];
            }
            if (i+z[i]-1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
            if (z[i] > max) {
                maxIndex = i;
                max = z[i];
            }
        }
        if (max < size) {
            return -1;
        }
        return maxIndex;
    }
}
