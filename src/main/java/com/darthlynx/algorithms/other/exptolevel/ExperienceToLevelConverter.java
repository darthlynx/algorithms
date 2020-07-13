package com.darthlynx.algorithms.other.exptolevel;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ExperienceToLevelConverter {

    private TreeMap<Long, Integer> expToLevelMap = getExperienceToLevelMapping();

    public static void main(String[] args) {
        ExperienceToLevelConverter conv = new ExperienceToLevelConverter();
        System.out.println(conv.getLevelByExperience(6004l));
        System.out.println(conv.getLevelByExperience(399l));
        System.out.println(conv.getLevelByExperience(1467l));
    }

    public Map<Integer, Long> getLevelToMinExperienceMapping() {
        Map<Integer, Long> levelToMinExperienceMapping = new HashMap<>();
        levelToMinExperienceMapping.put(1, 0L);
        levelToMinExperienceMapping.put(2, 100L);
        levelToMinExperienceMapping.put(3, 500L);
        levelToMinExperienceMapping.put(4, 1000L);
        levelToMinExperienceMapping.put(5, 2500L);
        levelToMinExperienceMapping.put(6, 5000L);
        levelToMinExperienceMapping.put(7, 10000L);
        // ...
        return levelToMinExperienceMapping;
    }


    public Integer getLevelByExperience(long exp) {
        return expToLevelMap.get(expToLevelMap.lowerKey(exp));
    }

    private TreeMap<Long, Integer> getExperienceToLevelMapping() {
        TreeMap<Long, Integer> treeMap = getLevelToMinExperienceMapping().entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue,
                        Map.Entry::getKey,
                        (oldValue, newValue) -> newValue, TreeMap::new));
        return treeMap;
    }
}
