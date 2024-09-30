package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/design-a-stack-with-increment-operation/
public class DesignIncrementalStack {
    class CustomStack {

        private int[] stack;
        private int maxSize;
        private int pointer;
    
        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            this.stack = new int[maxSize];
            this.pointer = 0;
        }
        
        public void push(int x) {
            if (pointer < maxSize) {
                stack[pointer] = x;
                pointer++;
            }
        }
        
        public int pop() {
            if (pointer == 0) {
                return -1;
            }
            int res = stack[pointer-1];
            pointer--;
            return res;
        }
        
        public void increment(int k, int val) {
            for (int i = 0; i < k && i < pointer; i++) {
                stack[i] = stack[i] + val;
            }
        }
    }
    
    /**
     * Your CustomStack object will be instantiated and called as such:
     * CustomStack obj = new CustomStack(maxSize);
     * obj.push(x);
     * int param_2 = obj.pop();
     * obj.increment(k,val);
     */
}
