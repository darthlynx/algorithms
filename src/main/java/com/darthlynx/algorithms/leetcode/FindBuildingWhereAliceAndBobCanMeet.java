package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/
public class FindBuildingWhereAliceAndBobCanMeet {

    // Time complexity: O(m * log m), where m = queries.length
    // Space complexity: O(n + m), where n = heights.length
    class Solution {
        
        // From editorial:
        // Each query asks for the closest index to the right with 
        // a value greater than both elements in the query pair. 
        // Instead of processing each query one at a time, 
        // we can optimize by checking, for each index in the heights array, 
        // if it can serve as the answer for any query.
        //
        // To do this efficiently, we can iterate through the heights array from left to right. 
        // For each index, we look for query pairs where both indices are smaller than the current index, 
        // and both values in the pair are smaller than the value at the current index. 
        // To make this process faster, we prioritize assigning answers to the smallest query pairs first.
        //
        // By maintaining the query pairs sorted based on their maximum value and index 
        // up to the current position, we can process them more efficiently.
        // 
        // To implement this idea, we process the heights array while managing the queries by storing them 
        // in a 2D array of arrays, where each subarray holds the queries for the corresponding building.
        // 
        // We begin by sorting and mapping the queries to track the index and values that we need. 
        // Using a priority queue, we store queries based on their maximum value and index. 
        // This helps us quickly retrieve the smallest index for processing.
        // 
        // As we move through the heights array, we pop the queries from the queue. 
        // For each query, if the current index is greater than both indices of the query, 
        // we assign the current index as the answer and store it. We also check if new queries, 
        // whose maximum index matches the current one, should be added to the queue for future processing.
        // This allows us to handle queries without reprocessing them repeatedly.
        //
        // Algorithm:
        // 
        // 1. Initialize storeQueries as a 2D array of arrays to store queries for each building.
        // 2. Initialize maxIndex as a priority queue to track the queries that need to be answered based on building heights.
        // 3. Initialize result as an array of -1 to store the answers for each query.
        // 4. Loop through each query:
        //         For each query (a, b):
        //             If the height of building a is less than building b and a is smaller than b, set result[currQuery] to b (building b is the answer).
        //             If the height of building a is greater than building b and a is greater than b, set result[currQuery] to a (building a is the answer).
        //             If a is equal to b, set result[currQuery] to a (both are the same building).
        //             Otherwise, store the query in storeQueries[max(a, b)] for future processing.
        // 
        // 5. Loop through each building index index:
        //         While the priority queue maxIndex has elements and the minimum value in maxIndex is smaller than the current building height:
        //             Set the corresponding query's result in result and pop the element from maxIndex (this query is answered).
        //         Push new queries from storeQueries[index] into maxIndex, sorting them by height.
        // 
        // 6. Return the result array containing the answers to all queries.
        public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            List<List<List<Integer>>> storeQueries = new ArrayList<>(heights.length);
            for (int i = 0; i < heights.length; i++) {
                storeQueries.add(new ArrayList<>());
            }
            PriorityQueue<List<Integer>> maxIndex = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
            int[] result = new int[queries.length];
            Arrays.fill(result, -1);

            // Store the mappings for all queries in storeQueries.
            for (int currQuery = 0; currQuery < queries.length; currQuery++) {
                int a = queries[currQuery][0], b = queries[currQuery][1];
                if (a < b && heights[a] < heights[b]) {
                    result[currQuery] = b;
                } else if (a > b && heights[a] > heights[b]) {
                    result[currQuery] = a;
                } else if (a == b) {
                    result[currQuery] = a;
                } else {
                    storeQueries
                            .get(Math.max(a, b))
                            .add(Arrays.asList(
                                    Math.max(heights[a], heights[b]),
                                    currQuery));
                }
            }

            // If the priority queue's minimum pair value is less than the current index of
            // height, it is an answer to the query.
            for (int index = 0; index < heights.length; index++) {
                while (!maxIndex.isEmpty() && maxIndex.peek().get(0) < heights[index]) {
                    result[maxIndex.peek().get(1)] = index;
                    maxIndex.poll();
                }
                // Push the with their maximum index as the current index in the priority queue.
                for (List<Integer> element : storeQueries.get(index)) {
                    maxIndex.offer(element);
                }
            }
            return result;
        }
    }
}
