package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class NextGreaterElement1 {

	// The next greater element of some element x in an array is the first greater
	// element that is to the right of x in the same array.

	// You are given two distinct 0-indexed integer arrays nums1 and nums2, where
	// nums1 is a subset of nums2.

	// For each 0 <= i < nums1.length, find the index j such that nums1[i] ==
	// nums2[j] and determine the next greater element of nums2[j] in nums2. If
	// there is no next greater element, then the answer for this query is -1.

	// Return an array ans of length nums1.length such that ans[i] is the next
	// greater element as described above.

	// Follow up: Could you find an O(nums1.length + nums2.length) solution?

	// efficient solution.
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		ArrayDeque<Integer> st = new ArrayDeque<>();
		Map<Integer, Integer> hmap = new HashMap<>();
		hmap.put(nums2[nums2.length - 1], -1);
		st.push(nums2[nums2.length - 1]);
		for (int i = nums2.length - 2; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() <= nums2[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				hmap.put(nums2[i], -1);
			} else {
				hmap.put(nums2[i], st.peek());
			}
			st.push(nums2[i]);
		}
		int[] result = new int[nums1.length];
		int index = 0;
		for (int i = 0; i < nums1.length; i++) {
			result[index] = hmap.get(nums1[i]);
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };
		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
	}

}
