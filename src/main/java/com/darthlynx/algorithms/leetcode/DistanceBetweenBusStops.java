package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/distance-between-bus-stops/
public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int directDist, reverseDist;
        if (start > destination) {
            directDist = getReverseDist(distance, destination, start);
            reverseDist = getDirectDist(distance, destination, start);
        } else {
            directDist = getDirectDist(distance, start, destination);
            reverseDist = getReverseDist(distance, start, destination);
        }

        return Math.min(directDist, reverseDist);
    }

    private int getDirectDist(int[] distance, int start, int destination) {
        int directDist = 0;

        for (int i = start; i < destination; i++) {
            directDist += distance[i];
        }
        return directDist;
    }

    private int getReverseDist(int[] distance, int start, int destination) {
        int reverseDist = 0;
        for (int i = 0; i < start; i++) {
            reverseDist += distance[i];
        }
        for (int i = destination; i < distance.length; i++) {
            reverseDist += distance[i];
        }
        return reverseDist;
    }
}
