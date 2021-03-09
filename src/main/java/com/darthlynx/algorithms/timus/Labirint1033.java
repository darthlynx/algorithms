package com.darthlynx.algorithms.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// https://timus.online/problem.aspx?space=1&num=1033
public class Labirint1033 {

    public static void main(String[] args) {

        List<String> inputs = getInputData();

        int n = Integer.parseInt(inputs.get(0));
        char[][] g = new char[n][n];
        for (int i = 1; i < n + 1; i++) {
            g[i - 1] = inputs.get(i).toCharArray();
        }

        char checked = '!';
        char empty = '.';
        char wall = '#';

        int nWalls = 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0,0));
        g[0][0] = checked;

        q.add(new Pair(n-1, n-1));
        g[n-1][n-1] = checked;

        int[][] mask = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.poll().y;

            int nx;
            int ny;
            for (int i = 0; i < mask.length; i++) {
                nx = x + mask[i][0];
                ny = y + mask[i][1];

                if (nx >= 0 && nx < n && ny >=0 && ny < n) {
                    char t = g[nx][ny];
                    if (t == empty) {
                        q.add(new Pair(nx, ny));
                        g[nx][ny] = checked;
                    } else if (t == wall) {
                        nWalls++;
                    }
                } else {
                    nWalls++;
                }
            }
        }

        int cellHeight = 3;
        int cellWidth = 3;
        int square = cellHeight * cellWidth * (nWalls - 4); // remove 4 walls for top cells according to the task
        System.out.println(square);
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
