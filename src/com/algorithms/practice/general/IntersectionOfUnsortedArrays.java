package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfUnsortedArrays {

	// Given two integer arrays nums1 and nums2, return an array of their
	// intersection. Each element in the result must be unique and you may return
	// the result in any order.

	// solution using sorting.
	// O(nlogn + mlogm + n + m)
	public static int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				if (i == 0 || nums1[i] != nums1[i - 1]) {
					result.add(nums1[i]);
				}
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

	// solution without sorting and using hashing.
	public static int[] intersectionHash(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		Set<Integer> hset = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			hset.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (hset.contains(nums2[i])) {
				result.add(nums2[i]);
				hset.remove(nums2[i]);
			}
		}
		return result.stream().mapToInt(k -> k).toArray();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		System.out.println("The intersection list is: " + Arrays.toString(intersection(nums1, nums2)));
		System.out.println("The intersection list is: " + Arrays.toString(intersectionHash(nums1, nums2)));
	}

}
