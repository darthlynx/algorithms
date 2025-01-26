package com.darthlynx.algorithms.codeforces.contest1512;


import java.io.*;
import java.util.StringTokenizer;

// https://codeforces.com/contest/1512/problem/B
public class B_AlmostRectangle {

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    public B_AlmostRectangle() {}
    public B_AlmostRectangle(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.tokenizer = null;
    }

    public void solve() {
        int t = nextInt();

        char star = '*';

        for (int m = 0; m < t; m++) {
            int n = nextInt();
            char[][] arr = new char[n][n];
            int x1 = -1;
            int y1 = -1;
            int x2 = -1;
            int y2 = -1;
            for (int j = 0; j < n; j++) {
                arr[j] = nextToken().toCharArray();
                for (int i = 0; i < n; i++) {
                    char cur = arr[j][i];
                    if (cur == star) {
                        if (x1 < 0) {
                            x1 = i;
                            y1 = j;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                    }
                }


            }

            if (x1 != x2 && y1 != y2) {
                arr[y1][x2] = star;
                arr[y2][x1] = star;
            } else {
                if (x1 == x2) {
                    arr[y1][(x1+1)%n] = star;
                    arr[y2][(x2+1)%n] = star;
                } else {
                    arr[(y1+1)%n][x1] = star;
                    arr[(y2+1)%n][x2] = star;
                }
            }

            for(int k = 0; k < n; k++) {
                System.out.println(new String(arr[k]));
            }

        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {

            new B_AlmostRectangle(reader, writer).solve();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
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
