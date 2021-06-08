package com.algorithms.practice.hashing;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoUnsortedArrays {

	// Given two arrays, count distinct elements in both arrays combined.

	// efficient solution.
	public static int union(int[] nums1, int[] nums2) {
		Set<Integer> hset = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			hset.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			hset.add(nums2[i]);
		}
		return hset.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 15, 20, 5, 15 };
		int[] nums2 = { 15, 15, 15, 20, 10 };
		int[] nums3 = { 10, 12, 15 };
		int[] nums4 = { 18, 12 };
		int[] nums5 = { 3, 3, 3 };
		int[] nums6 = { 3, 3 };
		System.out.println("The count of distinct elements in both arrays are: " + union(nums1, nums2));
		System.out.println("The count of distinct elements in both arrays are: " + union(nums3, nums4));
		System.out.println("The count of distinct elements in both arrays are: " + union(nums5, nums6));
	}

}
