package com.algorithms.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

	// Given an array of intervals where intervals[i] = [starti, endi], merge all
	// overlapping intervals, and return an array of the non-overlapping intervals
	// that cover all the intervals in the input.

	// 1 <= intervals.length <= 10^4
	// intervals[i].length == 2

	// efficient solution.
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> result = new ArrayList<>();
		int[] temp = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] > temp[1]) {
				result.add(temp);
				temp = intervals[i];
			} else {
				if (intervals[i][1] > temp[1]) {
					temp[1] = intervals[i][1];
				}
			}
		}
		if (result.size() == 0 || result.get(result.size() - 1) != temp) {
			result.add(temp);
		}
		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] intervals1 = { { 1, 4 }, { 4, 5 } };
		System.out.println("Non overlapping intervals are: " + Arrays.toString(merge(intervals)));
		System.out.println("Non overlapping intervals are: " + Arrays.toString(merge(intervals1)));
	}

}
