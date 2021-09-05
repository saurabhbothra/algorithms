package com.algorithms.practice.general;

import java.util.Arrays;

public class NonOverlappingIntervals {

	// Given an array of intervals intervals where intervals[i] = [starti, endi],
	// return the minimum number of intervals you need to remove to make the rest of
	// the intervals non-overlapping.

	// naive idea would be to consider each possible subset and check if there any
	// overlapping intervals. 2^n possibilities.

	// efficient solution, using greedy based on end times and sorting by start
	// times.
	public static int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		int count = 0;
		int i = 1;
		int[] curr = intervals[0];
		while (i < intervals.length) {
			if (intervals[i][0] >= curr[1]) {
				curr = intervals[i];
			} else {
				if (intervals[i][1] < curr[1]) {
					curr = intervals[i];
				}
				count++;
			}
			i++;
		}
		return count;
	}

	// efficient solution, using greedy technique based on end times and sorting by
	// end times.
	public static int eraseOverlapIntervalsEff(int[][] intervals) {
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		int count = 0;
		int i = 1;
		int[] curr = intervals[0];
		while (i < intervals.length) {
			if (intervals[i][0] >= curr[1]) {
				curr = intervals[i];
			} else {
				if (intervals[i][1] < curr[1]) {
					curr = intervals[i];
				}
				count++;
			}
			i++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out
				.println("The minimum number of intervals you need to remove is: " + eraseOverlapIntervals(intervals));
		System.out.println(
				"The minimum number of intervals you need to remove is: " + eraseOverlapIntervalsEff(intervals));
	}

}
