package com.algorithms.practice.dequeue;

public class DequeUsingArray {

	// Implement deque operations using array.

	public int[] arr;
	public int front;
	public int rear;
	public int count;

	/** Initialize your data structure here. Set the size of the deque to be k. */
	public DequeUsingArray(int k) {
		this.arr = new int[k];
		this.front = -1;
		this.rear = -1;
		this.count = 0;
	}

	/**
	 * Adds an item at the front of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean insertFront(int value) {
		if (this.count == this.arr.length) {
			return false;
		}
		if (this.front == -1) {
			this.rear++;
			this.front++;
		} else if (this.front == 0) {
			this.front = this.arr.length - 1;
		} else {
			this.front = (this.front - 1) % this.arr.length;
		}
		this.arr[this.front] = value;
		this.count++;
		return true;
	}

	/**
	 * Adds an item at the rear of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean insertLast(int value) {
		if (this.count == this.arr.length) {
			return false;
		}
		if (this.rear == -1) {
			this.front++;
		}
		this.rear = (this.rear + 1) % this.arr.length;
		this.arr[this.rear] = value;
		this.count++;
		return true;
	}

	/**
	 * Deletes an item from the front of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean deleteFront() {
		if (count == 0) {
			return false;
		}
		if (this.rear == this.front) {
			this.front = -1;
			this.rear = -1;
		} else {
			this.front = (this.front + 1) % this.arr.length;
		}
		this.count--;
		return true;
	}

	/**
	 * Deletes an item from the rear of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean deleteLast() {
		if (count == 0) {
			return false;
		}
		if (this.rear == this.front) {
			this.front = -1;
			this.rear = -1;
		} else {
			if (this.rear == 0) {
				this.rear = this.arr.length - 1;
			} else {
				this.rear = (this.rear - 1) % this.arr.length;
			}
		}
		this.count--;
		return true;
	}

	/** Get the front item from the deque. */
	public int getFront() {
		if (this.count == 0) {
			return -1;
		}
		return this.arr[this.front];
	}

	/** Get the last item from the deque. */
	public int getRear() {
		if (this.count == 0) {
			return -1;
		}
		return this.arr[this.rear];
	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return (this.count == 0);
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return (this.count == this.arr.length);
	}

	/** Returns the size of deque. */
	public int size() {
		return this.count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DequeUsingArray dq = new DequeUsingArray(3);
		System.out.println(dq.insertLast(1));
		System.out.println(dq.insertLast(2));
		System.out.println(dq.insertFront(3));
		System.out.println(dq.insertFront(4));
		System.out.println(dq.getRear());
		System.out.println(dq.isFull());
		System.out.println(dq.deleteLast());
		System.out.println(dq.insertFront(4));
		System.out.println(dq.getFront());
		System.out.println(dq.size());
	}

}
