package com.darthlynx.algorithms.codeforces.contest1512;

import java.util.Scanner;

// https://codeforces.com/contest/1512/problem/A
public class A_SpyDetected {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            if (arr[0] != arr[1] && arr[1] == arr[2]) {
                System.out.println(1);
            } else {
                int k = arr[0];
                for (int m = 1; m < n; m++) {
                    if (arr[m] != k) {
                        System.out.println(m+1);
                        break;
                    }
                }
            }
        }
    }
}
