package com.algorithms.practice.queue;

public class QueueUsingArray {

	// Implement queue operations using array. It should behave like a circular
	// queue.

	public int[] arr;
	public int front;
	public int rear;
	public int count;

	// initialize your data structure.
	public QueueUsingArray(int capacity) {
		this.arr = new int[capacity];
		this.front = -1;
		this.rear = -1;
		this.count = 0;
	}

	// adds an item to the back of the queue and returns true if operation was
	// successful.
	public boolean enqueue(int item) {
		if (this.count == this.arr.length) {
			return false;
		}
		if (this.front == -1) {
			this.front++;
		}
		this.count++;
		int rearIndex = (this.rear + 1) % this.arr.length;
		this.arr[rearIndex] = item;
		this.rear = rearIndex;
		return true;
	}

	// pops an item from front of the queue and returns true if operation was
	// successful.
	public boolean dequeue() {
		if (this.front == -1) {
			return false;
		}
		if (this.front == this.rear) {
			this.front = -1;
			this.rear = -1;
		} else {
			this.front = (this.front + 1) % this.arr.length;
		}
		this.count--;
		return true;
	}

	// returns the size of the queue.
	public int size() {
		return this.count;
	}

	// gets the front item of the queue.
	public int getFront() {
		if (this.front == -1) {
			return -1;
		}
		return this.arr[this.front];
	}

	// gets the last item of the queue.
	public int getLast() {
		if (this.front == -1) {
			return -1;
		}
		return this.arr[this.rear];
	}

	// checks whether queue is empty or not.
	public boolean isEmpty() {
		if (this.front == -1) {
			return true;
		}
		return false;
	}

	// checks whether queue has reached it full capacity or not.
	public boolean isFull() {
		if (this.count == this.arr.length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArray q = new QueueUsingArray(3);
		System.out.println(q.enqueue(1));
		System.out.println(q.enqueue(2));
		System.out.println(q.enqueue(3));
		System.out.println(q.enqueue(4));
		System.out.println(q.getLast());
		System.out.println(q.isFull());
		System.out.println(q.dequeue());
		System.out.println(q.enqueue(4));
		System.out.println(q.getLast());
	}

}
