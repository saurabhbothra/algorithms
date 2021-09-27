package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class QueueUsingStackNaive {

	// Implement a first in first out (FIFO) queue using only two stacks. The
	// implemented queue should support all the functions of a normal queue (push,
	// peek, pop, and empty).

	// All the calls to pop and peek are valid.

	public ArrayDeque<Integer> st1;
	public ArrayDeque<Integer> st2;
	public int front;

	public QueueUsingStackNaive() {
		this.st1 = new ArrayDeque<>();
		this.st2 = new ArrayDeque<>();
		this.front = -1;
	}

	// Pushes element x to the back of the queue.
	public void push(int x) {
		if (st1.isEmpty()) {
			front = x;
		}
		st1.push(x);
	}

	// Removes the element from the front of the queue and returns it.
	public int pop() {
		while (st1.size() > 1) {
			st2.push(st1.pop());
		}
		if (st2.size() == 0) {
			front = -1;
			return st1.pop();
		}
		front = st2.peek();
		int item = st1.pop();
		while (!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		return item;
	}

	// Returns the element at the front of the queue.
	public int peek() {
		return front;
	}

	// Returns true if the queue is empty, false otherwise.
	public boolean empty() {
		return st1.size() == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStackNaive myQueue = new QueueUsingStackNaive();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue.peek(); // return 1
		myQueue.pop(); // return 1, queue is [2]
		myQueue.empty(); // return false
	}

}
