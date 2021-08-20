package com.algorithms.practice.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RankTransformOfAnArray {

	// Given an array of integers arr, replace each element with its rank.

	// The rank represents how large the element is. The rank has the following
	// rules:

	// Rank is an integer starting from 1.

	// The larger the element, the larger the rank. If two elements are equal, their
	// rank must be the same.

	// Rank should be as small as possible.

	// efficient solution.
	public static int[] arrayRankTransform(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(arr[i1], arr[i2]));
		for (int i = 0; i < arr.length; i++) {
			pq.add(i);
		}
		int rank = 0;
		int prev = -1;
		int[] result = new int[arr.length];
		while (!pq.isEmpty()) {
			int num = pq.poll();
			if (prev == -1 || arr[prev] != arr[num]) {
				rank++;
				prev = num;
			}
			result[num] = rank;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 40, 10, 20, 30 };
		System.out.println("The rank is: " + Arrays.toString(arrayRankTransform(arr)));
	}

}
