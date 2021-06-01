package com.darthlynx.algorithms.timus;

import java.io.*;
import java.util.*;

// https://acm.timus.ru/problem.aspx?space=1&num=1080
public class MapColoring {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private int[] colors;

    public MapColoring(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.tokenizer = null;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {

            new MapColoring(reader, writer).solve();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void solve() {
        int n = nextInt();
        checkIfNodeIsSingle(n);

        Map<Integer, Set<Integer>> graph = new HashMap<>(n);

        for (int i = 1; i <= n; i++) {
            int k = nextInt();
            while (k != 0) {
                addNeighbour(graph, i, k);
                k = nextInt();
            }
            // set up second direction
            for (int neighbour: graph.get(i)) {
                addNeighbour(graph, neighbour, i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        colors = new int[n+1];
        for (int i = 0; i <= n; i++) {
            colors[i] = -1;
        }
        colors[1] = 0;

        bfs(queue, graph);
        printResults(colors);
    }

    private void checkIfNodeIsSingle(int n) {
        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }
    }

    private void addNeighbour(Map<Integer, Set<Integer>> graph, int node, int neighbour) {
        Set<Integer> neighbours = graph.get(node);
        if (neighbours == null) {
            neighbours = new HashSet<>();
            graph.put(node, neighbours);
        }
        graph.get(node).add(neighbour);
    }

    private void bfs(Queue<Integer> queue, Map<Integer, Set<Integer>> graph) {
        while (!queue.isEmpty()) {
            Integer currentCountry = queue.poll();
            int color = colors[currentCountry];
            Set<Integer> neighbours = graph.get(currentCountry);
            for (Integer neighbour : neighbours) {
                int reversedColor = reverseColor(color);
                int tmpColor = colors[neighbour];
                if (tmpColor >= 0 && tmpColor != reversedColor) {
                    System.out.println("-1");
                    System.exit(0);
                } else if (tmpColor < 0) {
                    colors[neighbour] = reversedColor;
                    queue.add(neighbour);
                }
            }

        }
    }

    private int reverseColor(int color) {
        return color == 1 ? 0 : 1;
    }

    private void printResults(int[] colors) {
        for (int i = 1; i < colors.length; i++) {
            System.out.print(colors[i]);
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
