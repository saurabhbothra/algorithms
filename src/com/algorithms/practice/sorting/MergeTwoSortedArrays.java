package com.algorithms.practice.sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
	// one sorted array.

	// The number of elements initialized in nums1 and nums2 are m and n
	// respectively. You may assume that nums1 has a size equal to m + n such that
	// it has enough space to hold additional elements from nums2.

	// efficient solution, two pointers and an extra pointer for taking no extra space.
	public static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
		int pointer1 = m - 1;
		int pointer2 = n - 1;
		int temp = m + n - 1;
		while (pointer1 >= 0 && pointer2 >= 0) {
			if (nums1[pointer1] >= nums2[pointer2]) {
				nums1[temp] = nums1[pointer1];
				pointer1--;
			} else {
				nums1[temp] = nums2[pointer2];
				pointer2--;
			}
			temp--;
		}
		while (pointer1 >= 0) {
			nums1[temp] = nums1[pointer1];
			pointer1--;
			temp--;
		}

		while (pointer2 >= 0) {
			nums1[temp] = nums2[pointer2];
			pointer2--;
			temp--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		mergeSortedArrays(nums1, 3, nums2, 3);
		System.out.println("The final sorted array is: " + Arrays.toString(nums1));
	}

}
