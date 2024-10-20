package com.darthlynx.algorithms.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/
public class MinStack {

    static class Node {
        int val;
        int min;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Stack<Node> minStack;

    public MinStack() {
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        int min = minStack.isEmpty() ? val : minStack.peek().min;
        minStack.add(new Node(val, val < min ? val : min));
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek().val;
    }
    
    public int getMin() {
        return minStack.peek().min;
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

}
