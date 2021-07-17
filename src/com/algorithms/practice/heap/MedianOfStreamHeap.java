package com.algorithms.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreamHeap {

	// The median is the middle value in an ordered integer list. If the size of the
	// list is even, there is no middle value and the median is the mean of the two
	// middle values.

	// Implement the MedianOfStream class.

	// Follow up:
	// If all integer numbers from the stream are in the range [0, 100], how would
	// you optimize your solution?

	// If 99% of all integer numbers from the stream are in the range [0, 100], how
	// would you optimize your solution?

	public PriorityQueue<Integer> minHeap;
	public PriorityQueue<Integer> maxHeap;

	/** initialize your data structure here. */
	public MedianOfStreamHeap() {
		this.minHeap = new PriorityQueue<>();
		this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	}

	// adds the integer num from the data stream to the data structure.
	public void addNum(int num) {
		if (this.maxHeap.size() == 0) {
			this.maxHeap.add(num);
			return;
		}
		if (this.maxHeap.size() > this.minHeap.size()) {
			if (num < this.maxHeap.peek()) {
				this.minHeap.add(this.maxHeap.poll());
				this.maxHeap.add(num);
			} else {
				this.minHeap.add(num);
			}
		} else {
			if (num >= this.minHeap.peek()) {
				this.maxHeap.add(this.minHeap.poll());
				this.minHeap.add(num);
			} else {
				this.maxHeap.add(num);
			}
		}
	}

	// returns the median of all elements so far. Answers within 10-5 of the actual
	// answer will be accepted.
	public double findMedian() {
		int totalSize = this.minHeap.size() + this.maxHeap.size();
		if (totalSize % 2 != 0) {
			return this.maxHeap.peek();
		} else {
			return (this.maxHeap.peek() + this.minHeap.peek()) / 2.0;
		}
	}

}
