package com.algorithms.practice.general;

import java.util.Arrays;

public class MinimumArrowsToBurstBalloons {

	// There are some spherical balloons spread in two-dimensional space. For each
	// balloon, provided input is the start and end coordinates of the horizontal
	// diameter. Since it's horizontal, y-coordinates don't matter, and hence the
	// x-coordinates of start and end of the diameter suffice. The start is always
	// smaller than the end.

	// An arrow can be shot up exactly vertically from different points along the
	// x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart
	// ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An
	// arrow once shot keeps traveling up infinitely.

	// Given an array points where points[i] = [xstart, xend], return the minimum
	// number of arrows that must be shot to burst all balloons.

	// efficient solution, using sorting by start times.
	public static int findMinArrowShotsStart(int[][] points) {
		Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));
		int count = 1;
		int[] curr = points[0];
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > curr[1]) {
				count++;
				curr = points[i];
			} else {
				curr[1] = Math.min(curr[1], points[i][1]);
			}
		}
		return count;
	}

	// efficient solution, using sorting by end times.
	public static int findMinArrowShotsEnd(int[][] points) {
		Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));
		int count = 1;
		int[] curr = points[0];
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > curr[1]) {
				count++;
				curr = points[i];
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		System.out.println(
				"The minimum number of arrows required to shoot all balloons is: " + findMinArrowShotsStart(points));
		System.out.println(
				"The minimum number of arrows required to shoot all balloons is: " + findMinArrowShotsEnd(points));
	}

}
