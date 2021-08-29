package com.algorithms.practice.segmentandbinaryindexedtree;

import java.util.Arrays;

public class ConstructingSegmentTree {

	// Given an array, you need to construct the segment tree array out of it where
	// each node value would be the sum of elements in array from range i to j,
	// inclusive.

	// efficient solution.
	public static int[] constructSegmentTree(int[] arr) {
		int[] segmentTree = new int[4 * arr.length];
		constructRec(arr, 0, arr.length - 1, 0, segmentTree);
		return segmentTree;
	}

	public static int constructRec(int[] arr, int start, int end, int index, int[] segmentTree) {
		if (start == end) {
			segmentTree[index] = arr[start];
			return arr[start];
		}
		int mid = start + (end - start) / 2;
		int leftSum = constructRec(arr, start, mid, 2 * index + 1, segmentTree);
		int rightSum = constructRec(arr, mid + 1, end, 2 * index + 2, segmentTree);
		segmentTree[index] = leftSum + rightSum;
		return leftSum + rightSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		System.out.println(Arrays.toString(constructSegmentTree(arr)));
	}

}
