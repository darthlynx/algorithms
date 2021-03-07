package com.darthlynx.algorithms.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://codeforces.com/problemset/problem/1322/A?locale=ru
public class InterestingCompetition {

    public static char OPEN = '(';
    public static char CLOSE = ')';

    public static void main(String[] args) {
        List<String> inputs = getInputData();
        int n = Integer.parseInt(inputs.get(0));
        char[] sequence = inputs.get(1).toCharArray();

        System.out.println(getMovesNumber(n, sequence));
    }

    private static int getMovesNumber(int n, char[] sequence) {
        if (n % 2 != 0) {
            return -1;
        }
        int depth = 0;
        for (char ch : sequence) {
            if (ch == OPEN) {
                depth++;
            } else {
                depth--;
            }
        }
        if (depth != 0) {
            return -1;
        }

        char[] balanced = new char[sequence.length];
        int movements = 0;
        for (int i = 0; i < sequence.length; i++){

        }

        return movements;
    }

    // input
    // 8
    // ))((())(
    // output 6

    // input
    // 3
    // (()
    // output -1

    private static List<String> getInputData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> inputs = new ArrayList<>();
            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                inputs.add(line);
            }
            return inputs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
