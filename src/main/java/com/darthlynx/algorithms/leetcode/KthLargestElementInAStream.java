package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestElementInAStream {
    class KthLargest {

        private PriorityQueue<Integer> heap;
        private int k;
    
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.heap = new PriorityQueue<>();
    
            for (int num : nums) {
                heap.offer(num);
            }
    
            // maintain heap size == k
            while (heap.size() > k) {
                heap.poll();
            }
        }
        
        public int add(int val) {
            heap.offer(val);
            if (heap.size() > k) {
                heap.poll();
            }
            return heap.peek();
        }
    }
    
    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
}
