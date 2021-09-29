package com.algorithms.practice.general;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

	// Design a class to find the kth largest element in a stream. Note that it is
	// the kth largest element in the sorted order, not the kth distinct element.

	// It is guaranteed that there will be at least k elements in the array when you
	// search for the kth element.

	public int k;
	public PriorityQueue<Integer> pq;

	// Initializes the object with the integer k and the stream of integers nums.
	public KthLargestElementInAStream(int k, int[] nums) {
		this.pq = new PriorityQueue<>();
		this.k = k;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count < k) {
				pq.offer(nums[i]);
				count++;
			} else {
				if (pq.peek() < nums[i]) {
					pq.poll();
					pq.offer(nums[i]);
				}
			}
		}
	}

	// Appends the integer val to the stream and returns the element representing
	// the kth largest element in the stream.
	public int add(int val) {
		if (pq.size() < k) {
			pq.offer(val);
		} else if (pq.peek() < val) {
			pq.poll();
			pq.offer(val);
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, new int[] { 4, 5, 8, 2 });
		kthLargest.add(3); // return 4
		kthLargest.add(5); // return 5
		kthLargest.add(10); // return 5
		kthLargest.add(9); // return 8
		kthLargest.add(4); // return 8
	}

}
