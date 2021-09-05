package com.algorithms.practice.general;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

	// Given an array of meeting time intervals intervals where intervals[i] =
	// [starti, endi], return the minimum number of conference rooms required.

	// Idea: Think about how we would approach this problem in a very simplistic
	// way. We will allocate rooms to meetings that occur earlier in the day v/s the
	// ones that occur later on, right?

	// If you've figured out that we have to sort the meetings by their start time,
	// the next thing to think about is how do we do the allocation?
	// There are two scenarios possible here for any meeting. Either there is no
	// meeting room available and a new one has to be allocated, or a meeting room
	// has freed up and this meeting can take place there.

	// An important thing to note is that we don't really care which room gets freed
	// up while allocating a room for the current meeting. As long as a room is
	// free, our job is done.

	// We already know the rooms we have allocated till now and we also know when
	// are they due to get free because of the end times of the meetings going on in
	// those rooms. We can simply check the room which is due to get vacated the
	// earliest amongst all the allocated rooms.

	// Following up on the previous hint, we can make use of a min-heap to store the
	// end times of the meetings in various rooms.

	// So, every time we want to check if any room is free or not, simply check the
	// topmost element of the min heap as that would be the room that would get free
	// the earliest out of all the other rooms currently occupied.

	// If the room we extracted from the top of the min heap isn't free, then no
	// other room is. So, we can save time here and simply allocate a new room.

	// efficient solution, using priority queue.
	public static int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(intervals[0][1]);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= pq.peek()) {
				pq.poll();
			}
			pq.add(intervals[i][1]);
		}
		return pq.size();
	}

	// efficient solution, using chronological ordering.
	public static int minMeetingRoomsChrono(int[][] intervals) {
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int count = 0;
		int i = 0;
		int j = 0;
		while (i < intervals.length) {
			if (start[i] < end[j]) {
				count++;
			} else {
				j++;
			}
			i++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println("The minimum number of conference rooms required is: " + minMeetingRooms(intervals));
		System.out.println("The minimum number of conference rooms required is: " + minMeetingRoomsChrono(intervals));
	}

}
