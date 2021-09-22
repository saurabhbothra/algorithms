package com.algorithms.practice.general;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

	// Given an n x n matrix where each of the rows and columns are sorted in
	// ascending order, return the kth smallest element in the matrix.

	// Note that it is the kth smallest element in the sorted order, not the kth
	// distinct element.

	// solution using quick-select algorithm, O(rc) on average.
	public static int kthSmallest(int[][] matrix, int k) {
		int[] nums = new int[matrix.length * matrix[0].length];
		int index = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				nums[index] = matrix[i][j];
				index++;
			}
		}
		int start = 0;
		int end = nums.length - 1;
		int result = 0;
		while (start <= end) {
			int randIndex = (int) ((Math.random() * (end + 1 - start)) + start);
			int pivotIndex = partition(nums, start, end, randIndex);
			if (pivotIndex == k - 1) {
				result = nums[pivotIndex];
				break;
			}
			if (pivotIndex > k - 1) {
				end = pivotIndex - 1;
			} else {
				start = pivotIndex + 1;
			}
		}
		return result;
	}

	private static int partition(int[] nums, int start, int end, int in) {
		int temp = nums[in];
		nums[in] = nums[end];
		nums[end] = temp;
		int index = start - 1;
		int pivotElement = nums[end];
		for (int i = start; i < end; i++) {
			if (nums[i] < pivotElement) {
				index++;
				temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;
			}
		}
		index++;
		temp = nums[end];
		nums[end] = nums[index];
		nums[index] = temp;
		return index;
	}

	// solution using min heap.
	public static int kthSmallestHeap(int[][] matrix, int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.element, n2.element));
		for (int i = 0; i < matrix.length; i++) {
			pq.offer(new Node(matrix[i][0], i, 0));
		}
		int result = 0;
		int count = 1;
		while (!pq.isEmpty()) {
			Node poppedNode = pq.poll();
			if (count == k) {
				result = poppedNode.element;
				break;
			}
			count++;
			if (poppedNode.col + 1 < matrix[0].length) {
				poppedNode.element = matrix[poppedNode.row][poppedNode.col + 1];
				poppedNode.col = poppedNode.col + 1;
				pq.offer(poppedNode);
			}
		}
		return result;
	}

	// solution using binary search and searching in rowwise and columnwise sorted
	// matrix.
	public static int kthSmallestBinary(int[][] matrix, int k) {
		int minVal = matrix[0][0];
		int maxVal = matrix[matrix.length - 1][matrix.length - 1];
		while (minVal < maxVal) {
			int midVal = minVal + (maxVal - minVal) / 2;
			int count = 0;
			int up = matrix.length - 1;
			int right = 0;
			int leftClosest = Integer.MIN_VALUE;
			int rightClosest = Integer.MAX_VALUE;
			while (up >= 0 && right < matrix.length) {
				if (matrix[up][right] <= midVal) {
					count = count + up + 1;
					if (matrix[up][right] > leftClosest) {
						leftClosest = matrix[up][right];
					}
					right++;
				} else {
					if (matrix[up][right] < rightClosest) {
						rightClosest = matrix[up][right];
					}
					up--;
				}
			}
			if (count == k) {
				return leftClosest;
			} else if (count > k) {
				// we dont want to lose duplicates if leftClosest is same as midVal.
				// so we include leftClosest in the range.
				maxVal = leftClosest;
			} else {
				minVal = rightClosest;
			}
		}
		return minVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(kthSmallest(matrix, 8));
		System.out.println(kthSmallestHeap(matrix, 8));
		System.out.println(kthSmallestBinary(matrix, 8));
	}

}

class Node {
	int element;
	int row;
	int col;

	Node(int element, int row, int col) {
		this.element = element;
		this.row = row;
		this.col = col;
	}
}
