package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/construct-string-with-repeat-limit/
public class ConstructStringWithRepeatLimit {

    // Time complexity: O(N * logK)
    // Space complexity: O(K), where K - number of unique chars in a string
    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] freq = new int[26];
    
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }
    
            PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Character.compare(b, a));
    
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 0) {
                    maxHeap.offer((char)(i + 'a'));
                }
            }
    
            StringBuilder result = new StringBuilder();
            while (!maxHeap.isEmpty()) {
                char ch = maxHeap.poll();
                int count = freq[ch - 'a'];
    
                int repeat = count > repeatLimit ? repeatLimit : count;
                for (int i = 0; i < repeat; i++) {
                    result.append(ch);
                }
    
                freq[ch - 'a'] = count - repeat;
    
                // append next char once if frequency is bigger than repeatLimit
                if (freq[ch - 'a'] > 0 && !maxHeap.isEmpty()){
                    char next = maxHeap.poll();
                    result.append(next);
                    freq[next - 'a']--;
                    if (freq[next - 'a'] > 0) {
                        maxHeap.offer(next);
                    }
                    maxHeap.offer(ch);
                }
            }
    
            return result.toString();
        }
    }

}
