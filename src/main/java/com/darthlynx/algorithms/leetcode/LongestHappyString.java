package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/longest-happy-string/
public class LongestHappyString {

    class Solution {
        static class Pair {
            int count;
            char ch;
            Pair(int count, char ch) {
                this.count = count;
                this.ch = ch;
            }
        }
    
        public String longestDiverseString(int a, int b, int c) {
            // max heap
            PriorityQueue<Pair> pq = new PriorityQueue<>((x1, x2) -> Integer.compare(x2.count, x1.count));
            if (a > 0) {
                pq.offer(new Pair(a, 'a'));
            }
            if (b > 0) {
                pq.offer(new Pair(b, 'b'));
            }
            if (c > 0) {
                pq.offer(new Pair(c, 'c'));
            }
    
            StringBuilder builder = new StringBuilder();
    
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                if (isHappyWithNewChar(builder, p.ch)) {
                    builder.append(p.ch);
                    p.count--;
                    if (p.count > 0) {
                        pq.offer(p);
                    }
                } else {
                    if (pq.isEmpty()) {
                        break;
                    }
                    Pair p2 = pq.poll();
                    builder.append(p2.ch);
                    p2.count--;
                    if (p2.count > 0) {
                        pq.offer(p2);
                    }
                    pq.offer(p); // return p without changing count
                }
            }
    
            return builder.toString();
        }
    
        private boolean isHappyWithNewChar(StringBuilder builder, char ch) {
            int size = builder.length();
            if (size < 2) {
                return true;
            }
    
            if (builder.charAt(size-1) != ch) {
                return true;
            }
    
            if (builder.charAt(size-1) == ch && builder.charAt(size-2) != ch) {
                return true;
            }
            return false;
        }
    }

}
