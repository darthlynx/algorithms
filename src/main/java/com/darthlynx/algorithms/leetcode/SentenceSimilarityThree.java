package com.darthlynx.algorithms.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/sentence-similarity-iii/
public class SentenceSimilarityThree {

    class Solution {
    
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
    
            Deque<String> d1 = new LinkedList<>();
            for (String s : s1) {
                d1.offer(s);
            }
    
            Deque<String> d2 = new LinkedList<>();
            for (String s : s2) {
                d2.offer(s);
            }
    
            while (!d1.isEmpty() && !d2.isEmpty() && d1.peekFirst().equals(d2.peekFirst())) {
                d1.pollFirst();
                d2.pollFirst();
            }
    
            while (!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().equals(d2.peekLast())) {
                d1.pollLast();
                d2.pollLast();
            }
    
            return d1.isEmpty() || d2.isEmpty();
        }
    
    }

    class Solution2 {

        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
    
            int left = 0;
            int right1 = s1.length - 1;
            int right2 = s2.length - 1;
    
            // checking prefixes
            while (left <= right1 && left <= right2 && s1[left].equals(s2[left])) {
                left++;
            }
    
            // checking suffixes
            while (left <= right1 && left <= right2 && s1[right1].equals(s2[right2])) {
                right1--;
                right2--;
            }
    
            return right1 < left || right2 < left;
    
        }
    
    }

}
