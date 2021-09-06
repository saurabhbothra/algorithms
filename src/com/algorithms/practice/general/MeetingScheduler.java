package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingScheduler {

	// Given the availability time slots arrays slots1 and slots2 of two people and
	// a meeting duration duration, return the earliest time slot that works for
	// both of them and is of duration duration.

	// If there is no common time slot that satisfies the requirements, return an
	// empty array.

	// The format of a time slot is an array of two elements [start, end]
	// representing an inclusive time range from start to end.

	// It is guaranteed that no two availability slots of the same person intersect
	// with each other. That is, for any two time slots [start1, end1] and [start2,
	// end2] of the same person, either start1 > end2 or start2 > end1.

	// efficient solution, using two pointers and sorting by start times.
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(slots1, (s1, s2) -> Integer.compare(s1[0], s2[0]));
		Arrays.sort(slots2, (s1, s2) -> Integer.compare(s1[0], s2[0]));
		int i = 0;
		int j = 0;
		while (i < slots1.length && j < slots2.length) {
			int person1Start = slots1[i][0];
			int person1End = slots1[i][1];
			int person2Start = slots2[j][0];
			int person2End = slots2[j][1];
			int commonStart = Math.max(person1Start, person2Start);
			int commonEnd = Math.min(person1End, person2End);
			if (person2Start <= person1End || person1Start <= person2End) {
				if ((commonStart + duration) <= commonEnd) {
					result.add(commonStart);
					result.add(commonStart + duration);
					break;
				}
			}
			if (commonEnd == person2End) {
				j++;
			} else {
				i++;
			}

		}
		return result;
	}

	// efficient solution, using min heap.
	public List<Integer> minAvailableDurationHeap(int[][] slots1, int[][] slots2, int duration) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[0], i2[0]));
		for (int i = 0; i < slots1.length; i++) {
			pq.add(slots1[i]);
		}
		for (int i = 0; i < slots2.length; i++) {
			pq.add(slots2[i]);
		}
		int[] curr = pq.poll();
		while (!pq.isEmpty()) {
			int[] slot = pq.poll();
			int commonEnd = Math.min(curr[1], slot[1]);
			if (slot[0] <= curr[1]) {
				if ((slot[0] + duration) <= commonEnd) {
					result.add(slot[0]);
					result.add(slot[0] + duration);
					break;
				}
			}
			if (commonEnd == curr[1]) {
				curr = slot;
			}
		}
		return result;
	}

}
