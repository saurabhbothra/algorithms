package com.algorithms.practice.dequeue;

import com.algorithms.practice.linkedlist.DoubleNode;

public class DequeUsingDoublyLinkedList {

	// Implement deque operations using doubly linked list.

	public int capacity;
	public int count;
	public DoubleNode front;
	public DoubleNode rear;

	/** Initialize your data structure here. Set the size of the deque to be k. */
	public DequeUsingDoublyLinkedList(int k) {
		this.capacity = k;
		this.count = 0;
		this.front = null;
		this.rear = null;
	}

	/**
	 * Adds an item at the front of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean insertFront(int value) {
		if (this.count == this.capacity) {
			return false;
		}
		DoubleNode newNode = new DoubleNode(value);
		this.count++;
		if (this.front == null) {
			this.front = newNode;
			this.rear = newNode;
		} else {
			newNode.next = this.front;
			this.front.prev = newNode;
			this.front = newNode;
		}
		return true;
	}

	/**
	 * Adds an item at the rear of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean insertLast(int value) {
		if (this.count == this.capacity) {
			return false;
		}
		DoubleNode newNode = new DoubleNode(value);
		this.count++;
		if (this.rear == null) {
			this.front = newNode;
			this.rear = newNode;
		} else {
			this.rear.next = newNode;
			newNode.prev = this.rear;
			this.rear = newNode;
		}
		return true;
	}

	/**
	 * Deletes an item from the front of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean deleteFront() {
		if (this.count == 0) {
			return false;
		}
		this.count--;
		if (this.front == this.rear) {
			this.front = null;
			this.rear = null;
		} else {
			this.front = this.front.next;
			this.front.prev = null;
		}
		return true;
	}

	/**
	 * Deletes an item from the rear of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean deleteLast() {
		if (this.count == 0) {
			return false;
		}
		this.count--;
		if (this.front == this.rear) {
			this.front = null;
			this.rear = null;
		} else {
			this.rear = this.rear.prev;
			this.rear.next = null;
		}
		return true;
	}

	/** Get the front item from the deque. */
	public int getFront() {
		if (this.count == 0) {
			return -1;
		}
		return this.front.data;
	}

	/** Get the last item from the deque. */
	public int getRear() {
		if (this.count == 0) {
			return -1;
		}
		return this.rear.data;
	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return (this.count == 0);
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return (this.count == this.capacity);
	}

	/** Returns the size of deque. */
	public int size() {
		return this.count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DequeUsingDoublyLinkedList dq = new DequeUsingDoublyLinkedList(3);
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
