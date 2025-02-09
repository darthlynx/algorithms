package com.darthlynx.algorithms.hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/bfsshortreach/problem
public class BreadthFirstSearchShortestReach {

    class Result {

        /*
         * Complete the 'bfs' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         * 1. INTEGER n - number of nodes
         * 2. INTEGER m - number of edges
         * 3. 2D_INTEGER_ARRAY edges
         * 4. INTEGER s - start from this node
         */

        public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
            // Write your code here
            int[] res = new int[n];
            Arrays.fill(res, -1);

            Map<Integer, List<Integer>> edgesMap = new HashMap<>();
            for (List<Integer> edge : edges) {
                edgesMap.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
                edgesMap.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(edge.get(0));
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            res[s - 1] = 0; // set distance to start node

            Set<Integer> visited = new HashSet<>();
            visited.add(s);

            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    int current = q.poll();
                    res[current - 1] = level * 6; // edge == 6
                    if (edgesMap.get(current) != null) {
                        for (int e : edgesMap.get(current)) {
                            if (!visited.contains(e)) {
                                q.add(e); // add all edges
                            }
                            visited.add(e);
                        }
                    }
                }
                level++;
            }
            List<Integer> result = new ArrayList<>();
            for (int val : res) {
                if (val != 0) {
                    result.add(val);
                }
            }

            return result;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int n = Integer.parseInt(firstMultipleInput[0]);
                int m = Integer.parseInt(firstMultipleInput[1]);
                List<List<Integer>> edges = new ArrayList<>();
                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());
                List<Integer> result = Result.bfs(n, m, edges, s);
                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

}
