package com.algorithms.practice.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MoreThanNByKOccurrences {

	// Given an array of size n and a number k,
	// print all elements whose count of occurrences
	// is more than (n/k)

	// naive solution
	public static void printElementsNaive(int[] nums, int k) {
		int threshold = nums.length / k;
		for (int i = 0; i < nums.length; i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (nums[j] == nums[i]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					count++;
				}
			}
			if (count > threshold) {
				System.out.print(nums[i] + " ");
			}
		}
	}

	// sorting solution.
	public static void printElementsSorting(int[] nums, int k) {
		int threshold = nums.length / k;
		Arrays.sort(nums);
		int count = 1;
		int i = 1;
		while (i < nums.length) {
			while (i < nums.length && nums[i] == nums[i - 1]) {
				count++;
				i++;
			}
			if (count > threshold) {
				System.out.print(nums[i - 1] + " ");
			}
			count = 1;
			i++;
		}
	}

	// efficient solution 1.
	public static void printElements(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
		}
		int threshold = nums.length / k;
		for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
			if (entry.getValue() > threshold) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}

	// efficient solution 2.
	public static void printElementsEfficient(int[] nums, int k) {
		Map<Integer, Integer> m = new HashMap<>();
		int threshold = nums.length / k;
		for (int i = 0; i < nums.length; i++) {
			if (m.containsKey(nums[i])) {
				m.put(nums[i], m.get(nums[i]) + 1);
			} else if (m.size() < k - 1) {
				m.put(nums[i], 1);
			} else {
				for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
					m.put(entry.getKey(), entry.getValue() - 1);
					if (m.get(entry.getKey()) == 0) {
						m.remove(entry.getKey());
					}
				}
			}
		}
		for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == entry.getKey()) {
					count++;
				}
			}
			if (count > threshold) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 30, 10, 20, 20, 10, 20, 30, 30 };
		int[] nums1 = { 30, 10, 20, 30, 30, 40, 30, 40, 30 };
		System.out.println("Elements with more than n / k occurences are:");
		printElementsEfficient(nums, 4);
		System.out.println();
		printElementsEfficient(nums1, 2);
	}

}
