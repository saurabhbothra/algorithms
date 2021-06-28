package com.algorithms.practice.dequeue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximum {

	// You are given an array of integers nums, there is a sliding window of size k
	// which is moving from the very left of the array to the very right. You can
	// only see the k numbers in the window. Each time the sliding window moves
	// right by one position.
	// Return the max sliding window.

	// 1 <= nums.length <= 10^5
	// 1 <= k <= nums.length

	// efficient solution.
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		int index = 0;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.offerLast(i);
		}
		for (int i = k; i < nums.length; i++) {
			result[index] = nums[dq.peekFirst()];
			index++;
			while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
				dq.pollFirst();
			}
			while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.offerLast(i);
		}
		result[index] = nums[dq.peekFirst()];
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println("The maximum for each sliding window is: " + Arrays.toString(maxSlidingWindow(nums, 3)));
	}

}
