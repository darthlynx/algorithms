package com.darthlynx.algorithms.timus;


import java.io.*;
import java.util.StringTokenizer;

// https://acm.timus.ru/problem.aspx?space=1&num=1184
public class CableMaster {

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;
    int maxLengthInCM = 10000000; // 100 km

    public CableMaster(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.tokenizer = null;

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            new CableMaster(reader, writer).solve();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void solve() {
        int n = nextInt();
        int k = nextInt();

        int[] cables = new int[n];

        for (int i = 0; i < n; i++) {
            cables[i] = (int) ((nextDouble() + 1e-8) * 100);
        }

        int res = binarySearch(maxLengthInCM, cables, k);
        System.out.printf("%.2f", res / 100.0);

    }

    private int binarySearch(int length, int[] cables, int k) {

        int l = 0;
        int r = length + 1;
        while (r > l + 1) {
            int sum = 0;
            int mid = (l + r) / 2;
            for (int cable: cables) {
                sum += cable / mid;
                if (sum >= k) {
                    break;
                }
            }
            if (sum >= k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;

    }

    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return tokenizer.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}
