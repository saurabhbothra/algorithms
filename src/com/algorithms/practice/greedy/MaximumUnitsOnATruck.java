package com.algorithms.practice.greedy;

import java.util.PriorityQueue;

class Box {
	int count;
	int unit;

	Box(int count, int unit) {
		this.count = count;
		this.unit = unit;
	}
}

public class MaximumUnitsOnATruck {

	// You are assigned to put some amount of boxes onto one truck. You are given a
	// 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi,
	// numberOfUnitsPerBoxi]:

	// numberOfBoxesi is the number of boxes of type i.
	// numberOfUnitsPerBoxi is the number of units in each box of the type i.
	// You are also given an integer truckSize, which is the maximum number of boxes
	// that can be put on the truck. You can choose any boxes to put on the truck as
	// long as the number of boxes does not exceed truckSize.

	// Return the maximum total number of units that can be put on the truck.

	// efficient solution.
	public static int maximumUnits(int[][] boxTypes, int truckSize) {
		PriorityQueue<Box> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(-n1.unit, -n2.unit));
		for (int[] b : boxTypes) {
			pq.add(new Box(b[0], b[1]));
		}

		int maxUnits = 0;
		while (!pq.isEmpty()) {
			Box box = pq.poll();
			if (truckSize >= box.count) {
				truckSize = truckSize - box.count;
				maxUnits += (box.count * box.unit);
			} else {
				maxUnits += truckSize * box.unit;
				truckSize = 0;
			}
			if (truckSize == 0) {
				break;
			}
		}
		return maxUnits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] boxes = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
		System.out.println("Maximum units collected are: " + maximumUnits(boxes, 4));
	}

}
