package com.darthlynx.algorithms.loops;

import java.util.*;
import java.util.stream.Collectors;

public class TopNCompetitors {

    public List<String> getTopNCompetitors(int numCompetitors, int topNCompetitors,
                                           List<String> competitors, int numReviews, List<String> reviews) {

        Map<String, Integer> occurrences = new HashMap<>();

        Set<String> compSet = new HashSet<>(competitors);

        Set<String> verified;
        for (String review : reviews) {
            String[] words = review.split(" ");
            verified = new HashSet<>();
            for (String word : words) {
                if (compSet.contains(word.toLowerCase()) && !verified.contains(word.toLowerCase())) {
                    occurrences.put(word.toLowerCase(), occurrences.getOrDefault(word.toLowerCase(), 0) + 1);
                    verified.add(word.toLowerCase());
                }
            }

        }

        return occurrences.entrySet().stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .limit(topNCompetitors)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }
}
