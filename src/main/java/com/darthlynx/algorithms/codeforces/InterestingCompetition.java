package com.darthlynx.algorithms.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://codeforces.com/problemset/problem/1322/A
public class InterestingCompetition {

    public static char OPEN = '(';

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
        int start = -1;
        int movements = 0;
        int pointer = 0;
        while (pointer < sequence.length) {
            if (sequence[pointer] == OPEN) {
                depth++;
            } else {
                depth--;
            }

            if (depth < 0) {
                if (start < 0) {
                    start = pointer; // update start position for unbalanced subsequence
                }
            } else if (depth == 0 && start >= 0) {  // if sequence becomes balanced and we have the start of unbalanced sequence,
                movements += (pointer - start + 1); // count the number of movements required
                start = -1;                         // and update the start (we don't have unbalanced subsequence at this time)
            }
            pointer++;
        }

        if (depth != 0) { // sequence is unbalanced
            return -1;
        }

        return movements;
    }

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
