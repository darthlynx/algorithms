package com.darthlynx.algorithms.leetcode;


import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
public class AlertUsingSameCardThreeTimes {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> visits = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            if (visits.containsKey(keyName[i])) {
                visits.get(keyName[i]).add(keyTime[i]);
            } else {
                visits.put(keyName[i], new ArrayList<>(List.of(keyTime[i])));
            }
        }

        return visits.entrySet()
                .stream()
                .filter(this::hasThreeOrMoreVisits)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

    }

    private boolean hasThreeOrMoreVisits(Map.Entry<String, List<String>> entry) {
        List<String> visits = entry.getValue();
        Collections.sort(visits);

        if (visits.size() >= 3) {
            for (int i = 2; i < visits.size(); i++) {
                if (parseTimeToSeconds(visits.get(i)) - parseTimeToSeconds(visits.get(i-2)) <= 60) {
                    return true;
                }
            }
        }
        return false;

    }

    private int parseTimeToSeconds(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
