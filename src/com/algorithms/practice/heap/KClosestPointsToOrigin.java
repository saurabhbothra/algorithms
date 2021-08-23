package com.algorithms.practice.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	// Given an array of points where points[i] = [xi, yi] represents a point on the
	// X-Y plane and an integer k, return the k closest points to the origin (0, 0).

	// The distance between two points on the X-Y plane is the Euclidean distance
	// (i.e., √(x1 - x2)^2 + (y1 - y2)^2).

	// You may return the answer in any order. The answer is guaranteed to be unique
	// (except for the order that it is in).

	// efficient solution.
	public static int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>(
				(p1, p2) -> Integer.compare(-(p1.x * p1.x + p1.y * p1.y), -(p2.x * p2.x + p2.y * p2.y)));
		int[][] result = new int[k][2];
		int i = 0;
		for (i = 0; i < k; i++) {
			pq.add(new Point(points[i][0], points[i][1]));
		}
		for (i = k; i < points.length; i++) {
			Point p = pq.peek();
			int currDistance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			if ((p.x * p.x + p.y * p.y) > currDistance) {
				pq.poll();
				pq.add(new Point(points[i][0], points[i][1]));
			}
		}
		int index = 0;
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			result[index][0] = p.x;
			result[index][1] = p.y;
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = { { 1, 3 }, { -2, 2 } };
		System.out.println("k closest points are:");
		int[][] result = kClosest(points, 1);
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
