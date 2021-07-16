package com.algorithms.practice.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	// Given K sorted arrays arranged in the form of a matrix of size K*K. The task
	// is to merge them into one sorted array.

	// efficient solution.
	public static List<Integer> mergeKSortedArrays(int[][] matrix, int k) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.data, n2.data));
		for (int i = 0; i < k; i++) {
			int data = matrix[i][0];
			pq.add(new Node(data, i, 0));
		}
		while (!pq.isEmpty()) {
			Node poppedNode = pq.poll();
			result.add(poppedNode.data);
			if (poppedNode.listIndex != matrix[poppedNode.listNo].length - 1) {
				int listNo = poppedNode.listNo;
				int listIndex = poppedNode.listIndex + 1;
				int data = matrix[listNo][listIndex];
				pq.add(new Node(data, listNo, listIndex));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> result = mergeKSortedArrays(arr, 3);
		Integer[] resultArr = result.toArray(new Integer[result.size()]);
		System.out.println("The sorted array is: " + Arrays.toString(resultArr));
	}

}

class Node {
	int data;
	int listNo;
	int listIndex;

	Node(int data, int listNo, int listIndex) {
		this.data = data;
		this.listNo = listNo;
		this.listIndex = listIndex;
	}
}
