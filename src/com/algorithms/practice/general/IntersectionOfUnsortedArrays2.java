package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class IntersectionOfUnsortedArrays2 {

	// Given two integer arrays nums1 and nums2, return an array of their
	// intersection. Each element in the result must appear as many times as it
	// shows in both arrays and you may return the result in any order.

	// Follow up:

	// What if the given array is already sorted? How would you optimize your
	// algorithm?

	// What if nums1's size is small compared to nums2's size? Which algorithm is
	// better?

	// What if elements of nums2 are stored on disk, and the memory is limited such
	// that you cannot load all elements into the memory at once?

	// solution using sorting.
	public static int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				result.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return result.stream().mapToInt(k -> k).toArray();
	}

	// solution using hashing.
	public static int[] intersectionHash(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		if (nums2.length < nums1.length) {
			int[] temp = nums2;
			nums2 = nums1;
			nums1 = temp;
		}
		Map<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			hmap.put(nums1[i], hmap.getOrDefault(nums1[i], 0) + 1);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (hmap.containsKey(nums2[i]) && hmap.get(nums2[i]) > 0) {
				result.add(nums2[i]);
				hmap.put(nums2[i], hmap.get(nums2[i]) - 1);
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		System.out.println("The intersection list is: " + Arrays.toString(intersection(nums1, nums2)));
		System.out.println("The intersection list is: " + Arrays.toString(intersectionHash(nums1, nums2)));
	}

}
