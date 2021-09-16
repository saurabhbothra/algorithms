package com.algorithms.practice.general;

public class ContainerWithMostWater {

	// Given n non-negative integers a1, a2, ..., an , where each represents a point
	// at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
	// of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
	// the x-axis forms a container, such that the container contains the most
	// water.

	// Notice that you may not slant the container.

	// efficient solution using two pointers and greedy technique.
	public static int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println("The area of container with most water is: " + maxArea(height));
	}

}
