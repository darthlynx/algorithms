package com.darthlynx.algorithms.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NestedSegments1987 {

    // https://timus.online/problem.aspx?space=1&num=1987&locale=ru
    public static void main(String[] args) {

        List<String> inputs = getInputData();

        int n = Integer.parseInt(inputs.get(0));

        List<Pair> segments = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] elem = inputs.get(i).split(" ");
            segments.add(new Pair(Integer.parseInt(elem[0]), i));
            segments.add(new Pair(Integer.parseInt(elem[1])+1, -1));
        }

        segments.sort((o1, o2) -> {
            if (o1.x > o2.x) {
                return 1;
            } else if (o1.x == o2.x) {
                return 0;
            } else {
                return -1;
            }
        });

        int m = Integer.parseInt(inputs.get(n+1));

        Stack<Integer> stack = new Stack<>();
        stack.add(-1);

        int position = 0;
        int finish = n+1+m;
        for (int i = n+2; i <= finish; i++) {
            int query = Integer.parseInt(inputs.get(i));
            for (int j = position; j < segments.size(); j++) {
                Pair p = segments.get(j);
                position = j;
                if (p.x <= query) {
                    if (p.y > 0) {
                        stack.add(p.y);
                    } else {
                        stack.pop();
                    }
                } else {
                    break;
                }

            }
            System.out.println(stack.peek());
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%d %d", x, y);
        }
    }

    private static List<String> getInputData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            List<String> inputs = new ArrayList<>();
            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                inputs.add(line);
            }
            reader.close();
            return inputs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
