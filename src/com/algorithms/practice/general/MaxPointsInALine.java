package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class MaxPointsInALine {

	// Given an array of points where points[i] = [xi, yi] represents a point on the
	// X-Y plane, return the maximum number of points that lie on the same straight
	// line.

	// All the points are unique.
	// 1 <= points.length <= 300

	// solution bycalculating slope.
	public int maxPoints(int[][] points) {
		if (points.length < 3) {
			return points.length;
		}
		Map<String, Set<int[]>> hmap = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int negativeCount = 0;
				int cminusCount = 0;
				int numerator = points[i][1] - points[j][1];
				if (numerator < 0) {
					negativeCount++;
				}
				int denominator = points[i][0] - points[j][0];
				int cden = denominator;
				if (denominator < 0) {
					negativeCount++;
					cminusCount++;
				}
				String key = "";
				if (denominator == 0) {
					key = "v" + points[i][0] + ":" + denominator;
				} else if (numerator == 0) {
					key = "h" + points[i][1] + ":" + numerator;
				} else {
					int[] reducedValues = fetchReducedFraction(numerator, denominator);
					numerator = reducedValues[0];
					denominator = reducedValues[1];
					int cnum = (points[i][0] * points[j][1]) - (points[i][1] * points[j][0]);
					if (cnum < 0) {
						cminusCount++;
					}
					reducedValues = fetchReducedFraction(cnum, cden);
					cnum = reducedValues[0];
					cden = reducedValues[1];
					key = ((negativeCount == 1) ? "-" : "") + Math.abs(numerator) + ":" + Math.abs(denominator) + ":"
							+ ((cminusCount == 1) ? "-" : "") + Math.abs(cnum) + ":" + Math.abs(cden);
				}
				if (!hmap.containsKey(key)) {
					hmap.put(key, new HashSet<>());
				}
				hmap.get(key).add(points[i]);
				hmap.get(key).add(points[j]);
			}
		}
		int maxPoints = 0;
		for (String key : hmap.keySet()) {
			Set<int[]> freq = hmap.get(key);
			if (freq.size() > maxPoints) {
				maxPoints = freq.size();
			}
		}
		return maxPoints;
	}

	private int[] fetchReducedFraction(int num, int den) {
		int g = gcd(Math.abs(num), Math.abs(den));
		while (g > 1) {
			num = num / g;
			den = den / g;
			g = gcd(Math.abs(num), Math.abs(den));
		}
		return new int[] { num, den };
	}

	private int gcd(int a, int b) {
		if (a < b) {
			return gcd(b, a);
		} else if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPointsInALine mp = new MaxPointsInALine();
		int[][] points = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
		System.out.println("The maximum points in a line is: " + mp.maxPoints(points));
	}

}
