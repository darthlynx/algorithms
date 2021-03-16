package com.darthlynx.algorithms.timus;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://timus.online/problem.aspx?space=1&num=1603
public class Erudite {

    private static final String INPUT_FILE = "1603_input.txt";
    private static Set<String> fWords = new HashSet<>();
    private static int[][] mask = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
        List<String> inputs = getInputData();

        char[][] grid = new char[4][4];

        for (int i = 0; i < 4; i++) {
            grid[i] = inputs.get(i).toCharArray();
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i, j, builder);
            }
        }

//        fWords.forEach(System.out::println);

        int n = Integer.parseInt(inputs.get(4));
        for (int i = 0; i < n; i++) {
            String word = inputs.get(5+i);
            if (fWords.contains(word)) {
                System.out.println(word + ": YES");
            } else {
                System.out.println(word + ": NO");
            }
        }

//        fWords.stream().filter(e -> e.startsWith("r")).forEach(System.out::println);

    }

    private static void dfs(char[][] grid, int i, int j, StringBuilder builder) {

        char tmp = grid[i][j];
        builder.append(tmp);
        fWords.add(builder.toString());

        grid[i][j] = '!';

        for (int[] arr : mask) {
            int x = arr[0] + i;
            int y = arr[1] + j;
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '!') {
                continue;
            }

            dfs(grid, x, y, builder);
        }

        builder.deleteCharAt(builder.length()-1);
        grid[i][j] = tmp;
    }

    private static List<String> getInputData() {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        URL inputLocation = Erudite.class.getClassLoader().getResource(INPUT_FILE);
        try (Reader r = onlineJudge || inputLocation == null ? new InputStreamReader(System.in) : new FileReader(inputLocation.getPath());
             BufferedReader reader = new BufferedReader(r)) {
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
