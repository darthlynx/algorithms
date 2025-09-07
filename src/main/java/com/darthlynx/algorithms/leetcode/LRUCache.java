package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
public class LRUCache {
    private final int cap;
    private Map<Integer, Node> address;
    private Node sentinel;
    private Node sentinelLast;

    public LRUCache(int capacity) {
        this.cap = capacity;
        address = new HashMap<>();
        sentinel = new Node(-1, -1, null, null);
        sentinelLast = new Node(-1, -1, sentinel, null);
        sentinel.next = sentinelLast;
    }

    // Time complexity: O(1)
    public int get(int key) {
        if (address.containsKey(key)) {
            // change order
            Node n = address.get(key);
            // remove node
            remove(n);
            // insert it at the beginning
            insertFirst(n);

            // return value
            return n.value;
        }
        return -1;
    }

    // Time complexity: O(1)
    public void put(int key, int value) {
        if (address.containsKey(key)) {
            remove(address.get(key));
        }
        Node n = new Node(key, value, null, null);
        insertFirst(n); // this will update the refs
        address.put(key, n);

        // clamp LL
        if (address.size() > cap) {
            Node lru = sentinelLast.prev;
            remove(lru);
            address.remove(lru.key);
            //sentinelLast.prev = lru.prev;
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private void remove(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        next.prev = prev;
        prev.next = next;
    }

    private void insertFirst(Node n) {
        Node next = sentinel.next;
        n.prev = sentinel;
        n.next = next;
        sentinel.next = n;
        next.prev = n;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
    }
}
