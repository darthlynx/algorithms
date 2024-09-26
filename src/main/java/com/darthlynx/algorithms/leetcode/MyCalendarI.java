package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/my-calendar-i/
public class MyCalendarI {
    class MyCalendar {

        class Interval {
            int start;
            int end;
            Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        private List<Interval> events;

        public MyCalendar() {
            this.events = new ArrayList<>();
        }
        
        public boolean book(int start, int end) {
            // inv [1, 3]
            //      ^
            // new [2, 4]
            //         ^
            for (Interval iv : events) {
                if (iv.start < end && iv.end > start) {
                    return false;
                }  
            }
            events.add(new Interval(start, end));
            return true;
        }
    }

    /**
     * Your MyCalendar object will be instantiated and called as such:
     * MyCalendar obj = new MyCalendar();
     * boolean param_1 = obj.book(start,end);
     */
}
