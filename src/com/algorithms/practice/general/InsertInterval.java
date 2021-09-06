package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

	// You are given an array of non-overlapping intervals intervals where
	// intervals[i] = [starti, endi] represent the start and the end of the ith
	// interval and intervals is sorted in ascending order by starti. You are also
	// given an interval newInterval = [start, end] that represents the start and
	// end of another interval.

	// Insert newInterval into intervals such that intervals is still sorted in
	// ascending order by starti and intervals still does not have any overlapping
	// intervals (merge overlapping intervals if necessary).

	// Return intervals after the insertion.

	// intervals is sorted by starti in ascending order.

	// efficient solution.
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		boolean intervalAdded = false;
		int i = 0;
		for (i = 0; i < intervals.length; i++) {
			if (newInterval[1] < intervals[i][0]) {
				result.add(newInterval);
				intervalAdded = true;
				break;
			} else if (newInterval[0] > intervals[i][1]) {
				result.add(intervals[i]);
			} else {
				newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
				newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			}
		}
		while (i < intervals.length) {
			result.add(intervals[i]);
			i++;
		}
		if (!intervalAdded) {
			result.add(newInterval);
		}
		return result.toArray(new int[result.size()][2]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 2, 5 };
		int[][] result = insert(intervals, newInterval);
		System.out.println("Intervals after insertion are:");
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

}
