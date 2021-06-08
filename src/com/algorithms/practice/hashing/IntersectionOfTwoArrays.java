package com.algorithms.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {

	// Given two integer arrays nums1 and nums2, return an array of their
	// intersection. Each element in the result must be unique and you may return
	// the result in any order.

	// naive solution.
	public static int[] intersectionNaive(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (nums1[j] == nums1[i]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}
			for (int j = 0; j < nums2.length; j++) {
				if (nums2[j] == nums1[i]) {
					result.add(nums1[i]);
					break;
				}
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}

	// efficient solution.
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> result = new HashSet<>();
		Set<Integer> hset = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			hset.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (hset.contains(nums2[i])) {
				result.add(nums2[i]);
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		System.out.println("The intersection of two arrays is: " + Arrays.toString(intersection(nums1, nums2)));
	}

}
