package com.algorithms.practice.general;

import java.util.Arrays;

public class MeetingRooms {

	// Given an array of meeting time intervals where intervals[i] = [starti, endi],
	// determine if a person could attend all meetings.

	// efficient solution.
	public static boolean canAttendMeetings(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return true;
		}
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		int[] prevMeeting = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < prevMeeting[1]) {
				return false;
			}
			prevMeeting = intervals[i];
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println("Can I attend all meetings: " + canAttendMeetings(intervals));
	}

}
