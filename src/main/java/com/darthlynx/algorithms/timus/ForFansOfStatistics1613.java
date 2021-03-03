package com.darthlynx.algorithms.timus;

import java.io.*;
import java.util.*;

public class ForFansOfStatistics1613 {

    // https://timus.online/problem.aspx?space=1&num=1613
    public static void main(String[] args) {

        List<String> inputs = getInputData();
        Map<Integer, TreeSet<Integer>> stats = getStats(stringToIntList(inputs.get(1)));

        List<QueryHolder> queries = getQueries(inputs);

        StringBuilder builder = new StringBuilder();
        TreeSet<Integer> set;
        for (QueryHolder query : queries) {
            if (stats.containsKey(query.count)) {
                set = stats.get(query.count);
                Integer floor = set.floor(query.rightEdge);
                if (floor != null && floor >= query.leftEdge) {
                    builder.append(1);
                } else {
                    builder.append(0);
                }
            } else {
                builder.append(0);
            }
        }
        System.out.print(builder);

    }

    private static List<QueryHolder> getQueries(List<String> inputs) {
        List<QueryHolder> queries = new ArrayList<>();
        for (int i=3; i<inputs.size(); i++) {
            queries.add(new QueryHolder(inputs.get(i).split(" ")));
        }
        return queries;
    }

    private static Map<Integer, TreeSet<Integer>> getStats(List<Integer> statList) {

        Map<Integer, TreeSet<Integer>> stats = new HashMap<>();
        TreeSet<Integer> treeSet;
        for (int i = 0; i < statList.size(); i++) {
            Integer key = statList.get(i);
            treeSet = stats.get(key);
            if (treeSet == null) {
                treeSet = new TreeSet<>();
            }
            treeSet.add(i+1);
            stats.put(key, treeSet);
        }
        return stats;
    }

    private static List<Integer> stringToIntList(String str) {
        List<Integer> intList = new ArrayList<>();
        for(String num : str.split(" ")) {
            intList.add(Integer.parseInt(num));
        }
        return intList;
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
            return inputs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class QueryHolder {
        private final int leftEdge;
        private final int rightEdge;
        private final int count;

        private QueryHolder(String[] inputs) {
            this.leftEdge = Integer.parseInt(inputs[0]);
            this.rightEdge = Integer.parseInt(inputs[1]);
            this.count = Integer.parseInt(inputs[2]);
        }
    }
}
