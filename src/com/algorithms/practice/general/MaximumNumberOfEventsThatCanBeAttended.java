package com.algorithms.practice.general;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {

	// Given an array of events where events[i] = [startDayi, endDayi]. Every event
	// i starts at startDayi and ends at endDayi.

	// You can attend an event i at any day d where startTimei <= d <= endTimei.
	// Notice that you can only attend one event at any time d.

	// Return the maximum number of events you can attend.

	// solution using sorting and heaps.
	public static int maxEvents(int[][] events) {
		Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int result = 0;
		int i = 0;
		for (int d = 1; d <= 100000; d++) {

			// remove all old events that couldn't be attended.
			while (!pq.isEmpty() && pq.peek() < d) {
				pq.poll();
			}

			// add all event's end days that are starting on day d.
			while (i < events.length && events[i][0] == d) {
				pq.offer(events[i][1]);
				i++;
			}

			// pop an event if it can be attended today.
			if (!pq.isEmpty()) {
				pq.poll();
				result++;
			}

			// check if we have processed all events.
			if (pq.isEmpty() && i == events.length) {
				break;
			}

		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] events = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 2 } };
		System.out.println("The maximum number of events that can be attended are: " + maxEvents(events));
	}

}
