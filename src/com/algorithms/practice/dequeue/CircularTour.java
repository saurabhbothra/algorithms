package com.algorithms.practice.dequeue;

import java.util.ArrayDeque;

public class CircularTour {

	// There are n gas stations along a circular route, where the amount of gas at
	// the ith station is gas[i].

	// You have a car with an unlimited gas tank and it costs cost[i] of gas to
	// travel from the ith station to its next (i + 1)th station. You begin the
	// journey with an empty tank at one of the gas stations.

	// Given two integer arrays gas and cost, return the starting gas station's
	// index if you can travel around the circuit once in the clockwise direction,
	// otherwise return -1. If there exists a solution, it is guaranteed to be
	// unique

	// naive solution.
	public static int canCompleteCircuitNaive(int[] gas, int[] cost) {
		int start = 0;
		int end = 0;
		int index = -1;
		while (start < gas.length) {
			boolean flag = true;
			int currGas = 0;
			while (true) {
				currGas = currGas + gas[end];
				if (currGas < cost[end]) {
					flag = false;
					break;
				}
				currGas = currGas - cost[end];
				end = (end == gas.length - 1) ? 0 : end + 1;
				if (end == start) {
					index = start;
					break;
				}
			}
			if (flag) {
				break;
			}
			start++;
			end = start;
		}
		return index;
	}

	// efficient solution wih extra space.
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int currGas = 0;
		int negativeGas = 0;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < gas.length; i++) {
			currGas = currGas + gas[i] - cost[i];
			dq.offerLast(i);
			while (!dq.isEmpty() && currGas < 0) {
				int temp = dq.pollFirst();
				negativeGas += gas[temp] - cost[temp];
				currGas = currGas - (gas[temp] - cost[temp]);
			}
		}
		currGas = currGas + negativeGas;
		if (currGas < 0) {
			return -1;
		}
		return dq.peekFirst();
	}

	// efficient solution.
	public static int canCompleteCircuitEfficient(int[] gas, int[] cost) {
		int start = 0;
		int currTotalTank = 0;
		int totalTank = 0;
		for (int i = 0; i < gas.length; i++) {
			int temp = gas[i] - cost[i];
			currTotalTank += temp;
			totalTank += temp;
			if (currTotalTank < 0) {
				start = i + 1;
				currTotalTank = 0;
			}
		}
		if (totalTank < 0) {
			return -1;
		}
		return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		System.out.println("You need to start from gas station at index: " + canCompleteCircuitEfficient(gas, cost));
	}

}
