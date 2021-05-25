package com.algorithms.practice.binarysearch;

public class MedianOfTwoSortedArrays {

	// Given two sorted arrays nums1 and nums2 of size m and n respectively, return
	// the median of the two sorted arrays.

	// The overall run time complexity should be O(log (m+n)).

	// 0 <= m <= 1000
	// 0 <= n <= 1000

	// efficient solution, binary search.
	public static double findMedian(int[] nums1, int[] nums2) {
		// both arrays are empty.
		if (nums1.length == 0 && nums2.length == 0) {
			return 0;
		}

		// always considering nums1 to be a smaller length array.
		if (nums2.length < nums1.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}

		// binary search for other cases.
		int start1 = 0;
		int end1 = nums1.length;
		double median = 0;

		while (start1 <= end1) {
			int i1 = (start1 + end1) / 2;
			int i2 = ((nums1.length + nums2.length + 1) / 2) - i1;
			// getting min and max values for two halves of the arrays.
			int min1 = (i1 == nums1.length) ? Integer.MAX_VALUE : nums1[i1];
			int max1 = (i1 == 0) ? Integer.MIN_VALUE : nums1[i1 - 1];
			int min2 = (i2 == nums2.length) ? Integer.MAX_VALUE : nums2[i2];
			int max2 = (i2 == 0) ? Integer.MIN_VALUE : nums2[i2 - 1];
			int maxLeft = Math.max(max1, max2);
			int minRight = Math.min(min1, min2);
			if (maxLeft <= minRight) {
				if ((nums1.length + nums2.length) % 2 == 0) {
					median = ((double) maxLeft + minRight) / 2;
				} else {
					median = (double) maxLeft;
				}
				break;
			} else if (max2 > min1) {
				start1 = i1 + 1;
			} else {
				end1 = i1 - 1;
			}
		}
		return median;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		System.out.println("The median of these sorted arrays is: " + findMedian(nums1, nums2));
	}

}
