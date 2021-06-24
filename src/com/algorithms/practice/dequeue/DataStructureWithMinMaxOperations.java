package com.algorithms.practice.dequeue;

import java.util.ArrayDeque;

public class DataStructureWithMinMaxOperations {

	// Design a data structure that supports the following operations in O(1) time.

	public ArrayDeque<Integer> dq;

	// Initialize your data structure.
	public DataStructureWithMinMaxOperations() {
		this.dq = new ArrayDeque<>();
	}

	// inserts the minimum element into the data structure. Always assumes that
	// inserted element is smaller than current elements in data structure.
	public boolean insertMin(int item) {
		this.dq.offerFirst(item);
		return true;
	}

	// inserts the maximum element into the data structure. Always assumes that
	// inserted element is greater than current elements in data structure.
	public boolean insertMax(int item) {
		this.dq.offerLast(item);
		return true;
	}

	// gets the minimum element in the data structure.
	public int getMin() {
		if (this.dq.isEmpty()) {
			return -1;
		}
		return this.dq.peekFirst();
	}

	// gets the maximum element in the data structure.
	public int getMax() {
		if (this.dq.isEmpty()) {
			return -1;
		}
		return this.dq.peekLast();
	}

	// removes the current minimum in the data structure.
	public int extractMin() {
		if (this.dq.isEmpty()) {
			return -1;
		}
		return this.dq.pollFirst();
	}

	// removes the current maximum in the data structure.
	public int extractMax() {
		if (this.dq.isEmpty()) {
			return -1;
		}
		return this.dq.pollLast();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataStructureWithMinMaxOperations ds = new DataStructureWithMinMaxOperations();
		System.out.println(ds.insertMin(5));
		System.out.println(ds.insertMax(10));
		System.out.println(ds.insertMin(3));
		System.out.println(ds.insertMax(15));
		System.out.println(ds.insertMin(2));
		System.out.println(ds.getMin());
		System.out.println(ds.getMax());
		System.out.println(ds.insertMin(1));
		System.out.println(ds.getMin());
		System.out.println(ds.insertMax(20));
		System.out.println(ds.getMax());
	}

}
