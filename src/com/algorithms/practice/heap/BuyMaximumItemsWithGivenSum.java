package com.algorithms.practice.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BuyMaximumItemsWithGivenSum {

	// Given an array which represents cost of n items and a sum, find count of
	// maximum items that can be purchased from given sum.

	// naive solution.
	public static int countMaxItemsNaive(int[] arr, int sum) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = sum - arr[i];
			if (temp >= 0) {
				sum = temp;
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	// efficient solution.
	public static int countMaxItems(int[] arr, int sum) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int maxCount = 0;
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		while (!pq.isEmpty() && pq.peek() <= sum) {
			maxCount++;
			sum = sum - pq.poll();
		}
		return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 12, 5, 111, 200 };
		int[] arr1 = { 20, 10, 5, 30, 100 };
		System.out.println("The maximum items that can be purchased is: " + countMaxItems(arr, 10));
		System.out.println("The maximum items that can be purchased is: " + countMaxItems(arr1, 35));
	}

}
