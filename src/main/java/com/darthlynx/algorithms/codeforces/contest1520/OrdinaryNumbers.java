package com.darthlynx.algorithms.codeforces.contest1520;

import java.io.*;
import java.util.StringTokenizer;

// https://codeforces.com/contest/1520/problem/B
public class OrdinaryNumbers {

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    public OrdinaryNumbers(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.tokenizer = null;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            new OrdinaryNumbers(reader, writer).solve();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void solve() {
        int t = nextInt();

        while (t > 0) {
            int n = nextInt();
            writer.println(calculateOrdinaryNumbers(n));
            t--;
        }
    }

    public int calculateOrdinaryNumbers(int n) {
        int oNums = 0;
        for (int i = 1; i <= n; i++) {
            if (isOrdinary(i)) {
                oNums++;
            }
        }
        return oNums;
    }

    private boolean isOrdinary(int n) {
        if (n <= 9) {
            return true;
        }
        String s = String.valueOf(n);
        char first = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != first) {
                return false;
            }
        }
        return true;
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
}
