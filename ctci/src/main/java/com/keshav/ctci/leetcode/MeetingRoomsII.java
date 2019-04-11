package com.keshav.ctci.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 253. Meeting Rooms II
 Medium

 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 Example 1:

 Input: [[0, 30],[5, 10],[15, 20]]
 Output: 2
 Example 2:

 Input: [[7,10],[2,4]]
 Output: 1
 */
public class MeetingRoomsII {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int meetingRooms(Interval[] intervals) {
        if (intervals == null) return 0;
        int n = intervals.length;
        int rooms = 0;
        if (n < 2) return 1;

        int[] startTime = new int[n];
        int[] endTimes = new int[n];
        int start = 0;
        int end = 0;

        for (int i=0; i<n ; i++) {
            startTime[i] = intervals[i].start;
            endTimes[i] = intervals[i].end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTimes);

        while (start != n) {
            if (startTime[start] < endTimes[end]) {
                start++;
                rooms++;
                continue;
            }
            end++;
            start++;
        }

        return rooms;
    }

    public void play() {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0,30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);
        System.out.println(meetingRooms(intervals));

        intervals = new Interval[2];
        intervals[0] = new Interval(7,10);
        intervals[1] = new Interval(2, 4);
        System.out.println(meetingRooms(intervals));
    }

    public static void main(String args[]) {
        MeetingRoomsII mr = new MeetingRoomsII();
        mr.play();
    }
}
