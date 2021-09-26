package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElement2 {

	// Given a circular integer array nums (i.e., the next element of
	// nums[nums.length - 1] is nums[0]), return the next greater number for every
	// element in nums.

	// The next greater number of a number x is the first greater number to its
	// traversing-order next in the array, which means you could search circularly
	// to find its next greater number. If it doesn't exist, return -1 for this
	// number.

	// efficient solution using stack.
	public static int[] nextGreaterElements(int[] nums) {
		int[] result = new int[nums.length];
		ArrayDeque<Integer> st = new ArrayDeque<>();
		int index = nums.length - 1;
		int prev = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() <= nums[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				while (nums[prev] <= nums[i] && prev < i) {
					prev++;
				}
				if (prev >= i) {
					result[index] = -1;
				} else {
					result[index] = nums[prev];
				}
			} else {
				result[index] = st.peek();
			}
			st.push(nums[i]);
			index--;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 3 };
		System.out.println(Arrays.toString(nextGreaterElements(nums)));
	}

}
