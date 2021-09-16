package com.algorithms.practice.arrays;

import java.util.ArrayDeque;

public class TrappingRainWaterPart1 {

	// Given n non-negative integers representing an elevation map where the width
	// of each bar is 1, compute how much water it can trap after raining.

	// n >= 0

	// efficient solution, dp solution, theta(n) extra space.
	public static int trapDp(int[] height) {
		int[] leftArrMax = new int[height.length];
		int[] rightArrMax = new int[height.length];
		int waterCollected = 0;
		int maxValue = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > maxValue) {
				maxValue = height[i];
			}
			leftArrMax[i] = maxValue;
		}

		maxValue = 0;
		for (int i = height.length - 1; i >= 0; i--) {
			if (height[i] > maxValue) {
				maxValue = height[i];
			}
			rightArrMax[i] = maxValue;
		}

		for (int i = 0; i < height.length; i++) {
			waterCollected += Math.min(leftArrMax[i], rightArrMax[i]) - height[i];
		}
		return waterCollected;
	}

	// efficient solution, using stack.
	public static int trapStack(int[] height) {
		int waterTrapped = 0;
		ArrayDeque<Integer> st = new ArrayDeque<>();
		for (int i = 0; i < height.length; i++) {
			while (!st.isEmpty() && height[i] > height[st.peek()]) {
				int pop = st.pop();
				if (st.isEmpty()) {
					break;
				}
				int distance = i - st.peek() - 1;
				waterTrapped += distance * (Math.min(height[i], height[st.peek()]) - height[pop]);
			}
			st.push(i);
		}
		return waterTrapped;
	}

	// efficient solution, theta(1) space.
	public static int trap(int[] height) {
		int waterCollected = 0;
		int leftMax = 0;
		int rightMax = 0;
		int start = 0;
		int end = height.length - 1;
		while (start <= end) {
			if (leftMax <= rightMax) {
				if (leftMax >= height[start]) {
					waterCollected = waterCollected + leftMax - height[start];
				} else {
					leftMax = height[start];
				}
				start++;
			} else {
				if (rightMax >= height[end]) {
					waterCollected = waterCollected + rightMax - height[end];
				} else {
					rightMax = height[end];
				}
				end--;
			}
		}
		return waterCollected;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 3, 0, 1, 2, 5 };
		System.out.println("The amount of water collected is: " + trap(height));
		System.out.println("The amount of water collected is: " + trapDp(height));
		System.out.println("The amount of water collected is: " + trapStack(height));
	}

}
