package com.darthlynx.algorithms.leetcode;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentElements {

    public List<String> topKFrequent(String[] words, int k) {
        // calculate frequencies
        // put into priority queue
        // limit the range

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word: words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((e1, e2) -> {
            // filter by frequency
            // or else filter by lexicographical order
            int res = wordCount.get(e2) - wordCount.get(e1);
            if (res != 0) {
                return res;
            } else {
                return e1.compareTo(e2);
            }
        });

        queue.addAll(wordCount.keySet());

        // limit result list
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.remove());
        }
        return result;
    }
}
