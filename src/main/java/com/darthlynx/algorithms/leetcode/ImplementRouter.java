package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/implement-router/
public class ImplementRouter {

    // TLE
    class Router {

        private int counter = 0;
        private static final String delimiter = "#";
        private int memoryLimit;
        private PriorityQueue<int[]> minHeap;
        private Set<String> packets;
        private Map<Integer, List<Integer>> destinationToTimestamp;

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            minHeap = new PriorityQueue<>((a, b) -> {
                if (a[2] == b[2]) {
                    return Integer.compare(a[3], b[3]);
                }
                return Integer.compare(a[2], b[2]);
            });
            packets = new HashSet<>();
            destinationToTimestamp = new HashMap<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            int[] packet = new int[] { source, destination, timestamp, counter++ };
            String packetKey = toKey(packet);
            if (packets.contains(packetKey)) {
                return false;
            }

            minHeap.offer(packet);
            packets.add(packetKey);
            destinationToTimestamp.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
            Collections.sort(destinationToTimestamp.get(destination));

            // keep memory limit
            while (minHeap.size() > memoryLimit) {
                int[] tbd = minHeap.poll();
                packets.remove(toKey(tbd));
                List<Integer> timestamps = destinationToTimestamp.get(tbd[1]);
                timestamps.remove((Integer) tbd[2]); // cast to object to remove object instead of index
            }
            return true;
        }

        public int[] forwardPacket() {
            if (minHeap.isEmpty()) {
                return new int[] {};
            }

            int[] packet = minHeap.poll();
            packets.remove(toKey(packet));
            List<Integer> timestamps = destinationToTimestamp.get(packet[1]);
            timestamps.remove((Integer) packet[2]);
            return Arrays.copyOf(packet, 3); // drop counter from the packet
        }

        public int getCount(int destination, int startTime, int endTime) {
            if (!destinationToTimestamp.containsKey(destination)) {
                return 0;
            }
            List<Integer> timestamps = destinationToTimestamp.get(destination);

            int indexLower = lowerBound(startTime, timestamps);
            int indexHigher = upperBound(endTime, timestamps);

            return indexHigher - indexLower + 1;
        }

        private int lowerBound(int startTime, List<Integer> timestamps) {
            int bad = -1;
            int good = timestamps.size();

            while (good - bad > 1) {
                int mid = bad + (good - bad) / 2;

                if (timestamps.get(mid) < startTime) {
                    bad = mid;
                } else {
                    good = mid;
                }
            }

            return good;
        }

        private int upperBound(int endTime, List<Integer> timestamps) {
            int good = -1;
            int bad = timestamps.size();

            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;

                if (timestamps.get(mid) <= endTime) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }

            return good;
        }

        private String toKey(int[] packet) {
            return packet[0] + delimiter + packet[1] + delimiter + packet[2];
        }
    }

    /**
     * Your Router object will be instantiated and called as such:
     * Router obj = new Router(memoryLimit);
     * boolean param_1 = obj.addPacket(source,destination,timestamp);
     * int[] param_2 = obj.forwardPacket();
     * int param_3 = obj.getCount(destination,startTime,endTime);
     */
}
