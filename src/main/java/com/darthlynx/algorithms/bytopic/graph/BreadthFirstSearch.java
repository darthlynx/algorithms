package com.darthlynx.algorithms.bytopic.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearch {

    static Person p1 = new Person("Simon", Profession.BUYER);

    public static void main(String[] args) {
        Map<Person, List<Person>> graph = prepareGraph();
        System.out.println(bfs(graph, p1));
    }

    public static Person bfs(Map<Person, List<Person>> graph, Person key) {
        ArrayDeque<Person> deque = new ArrayDeque<>();
        List<Person> checked = new ArrayList<>(graph.size());
        deque.add(key);
        int i = 0;
        while (!deque.isEmpty()) {
            Person checkPerson = deque.poll();
            System.out.println(i);
            i++;
            if (!checked.contains(checkPerson)) {
                if (checkPerson.getProfession().equals(Profession.SELLER)) {
                    return checkPerson;
                } else {
                    checked.add(checkPerson);
                    deque.addAll(graph.get(checkPerson));
                }
            }
        }
        return null;
    }

    private static Map<Person, List<Person>> prepareGraph() {
        Map<Person, List<Person>> graph = new HashMap<>();
        Person p2 = new Person("John", Profession.BUYER);
        Person p3 = new Person("David", Profession.DEALER);
        Person p4 = new Person("Cliff", Profession.BUYER);
        Person p5 = new Person("Sam", Profession.BUYER);
        Person p6 = new Person("Deadman", Profession.DEALER);
        Person p7 = new Person("Joshua", Profession.BUYER);
        Person p8 = new Person("Tim", Profession.DISTRIBUTOR);
        Person p9 = new Person("Clair", Profession.BUYER);
        Person p10 = new Person("Sarah", Profession.DISTRIBUTOR);
        Person p11 = new Person("Donald", Profession.SELLER);
        Person p12 = new Person("Amanda", Profession.BUYER);

        graph.put(p1, Arrays.asList(p2, p3, p4));
        graph.put(p2, Arrays.asList(p5, p6));
        graph.put(p3, Arrays.asList(p6, p7));
        graph.put(p4, Arrays.asList(p8, p9));
        graph.put(p5, Arrays.asList(p12));
        graph.put(p6, Collections.emptyList());
        graph.put(p7, Collections.emptyList());
        graph.put(p8, Arrays.asList(p10, p11));
        graph.put(p9, Collections.emptyList());
        graph.put(p10, Collections.emptyList());
        graph.put(p11, Collections.emptyList());
        graph.put(p12, Collections.emptyList());

        return graph;
    }
}
