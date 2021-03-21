package com.darthlynx.algorithms.timus;

import java.io.*;
import java.net.URL;
import java.util.*;

// https://timus.online/problem.aspx?space=1&num=1837&locale=ru
public class IsenbaevsNumber1837 {

    private static final String INPUT_FILE = "1837_input.txt";

    static class Player {
        private final String lastName;
        private String parent;

        Player(String lastName, String parent) {
            this.lastName = lastName;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return lastName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return lastName.equals(player.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(lastName);
        }
    }

    // useful link: https://e-maxx.ru/algo/bfs
    public static void main(String[] args) {
        List<String> inputs = getInputData();

        int n = Integer.parseInt(inputs.get(0));

        Map<Player, Set<Player>> graph = new HashMap<>();
        Map<String, Integer> visited = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            addGraphEntry(graph, inputs.get(i));
        }

        bfs(graph, visited);
        addUndefined(graph, visited);

        printResult(visited);
    }

    private static void bfs(Map<Player, Set<Player>> graph, Map<String, Integer> visited) {
        ArrayDeque<Player> queue = new ArrayDeque<>();

        Player isenbaev = graph.keySet().stream()
                .filter(p -> p.lastName.equals("Isenbaev"))
                .findAny().orElse(null);
        if (isenbaev == null) {
            return;
        }
        queue.addAll(graph.get(isenbaev));
        visited.put(isenbaev.lastName, 0);

        while (!queue.isEmpty()) {
            Player current = queue.poll();
            if (!visited.containsKey(current.lastName)) {
                visited.put(current.lastName, visited.get(current.parent)+1);
                queue.addAll(graph.get(current));
            }
        }
    }

    private static void addGraphEntry(Map<Player, Set<Player>> graph, String line) {
        String[] names = line.split(" ");

        for (String name: names) {
            Player player = new Player(name, null);
            Set<Player> players = graph.get(player);
            if (players == null) {
                players = new HashSet<>();
            }
            Set<Player> teammates = new HashSet<>();
            for (String p: names) {
                if (!p.equals(name)) {
                    teammates.add(new Player(p, name));
                }
            }
            players.addAll(teammates);
            graph.put(player, players);
        }
    }

    private static void printResult(Map<String, Integer> visited) {
        for (Map.Entry<String, Integer> entry: visited.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue() < 0 ? "undefined" : String.valueOf(entry.getValue());
            System.out.printf("%s %s%n", name, value);
        }
    }

    private static void addUndefined(Map<Player, Set<Player>> graph, Map<String, Integer> visited) {
        for (Player p : graph.keySet()) {
            if (!visited.containsKey(p.lastName)) {
                visited.put(p.lastName, -1);
            }
        }
    }

    private static List<String> getInputData() {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        URL inputLocation = IsenbaevsNumber1837.class.getClassLoader().getResource(INPUT_FILE);
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
