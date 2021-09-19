package com.algorithms.practice.general;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

public class LeastNumberOfUniqueIntegersAfterKRemovals {

	// Given an array of integers arr and an integer k. Find the least number of
	// unique integers after removing exactly k elements.

	// solution using heap and hash map.
	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(hmap.get(i1), hmap.get(i2)));
		for (int i = 0; i < arr.length; i++) {
			hmap.put(arr[i], hmap.getOrDefault(arr[i], 0) + 1);
		}
		for (int key : hmap.keySet()) {
			pq.add(key);
		}
		for (int i = 0; i < k; i++) {
			int num = pq.poll();
			if (hmap.get(num) == 1) {
				hmap.remove(num);
			} else {
				hmap.put(num, hmap.get(num) - 1);
				pq.add(num);
			}
		}
		return hmap.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 3, 1, 1, 3, 3, 2 };
		System.out.println("The least number of unique integers are: " + findLeastNumOfUniqueInts(nums, 3));
	}

}
