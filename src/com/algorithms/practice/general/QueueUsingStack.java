package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class QueueUsingStack {

	// Implement a first in first out (FIFO) queue using only two stacks. The
	// implemented queue should support all the functions of a normal queue (push,
	// peek, pop, and empty).

	// All the calls to pop and peek are valid.

	// Follow-up: Can you implement the queue such that each operation is amortized
	// O(1) time complexity? In other words, performing n operations will take
	// overall O(n) time even if one of those operations may take longer.

	public ArrayDeque<Integer> st1;
	public ArrayDeque<Integer> st2;
	public int front;

	public QueueUsingStack() {
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
		if (!st2.isEmpty()) {
			return st2.pop();
		}
		while (!st1.isEmpty()) {
			st2.push(st1.pop());
		}
		return st2.pop();
	}

	// Returns the element at the front of the queue.
	public int peek() {
		if (!st2.isEmpty()) {
			return st2.peek();
		}
		return front;
	}

	// Returns true if the queue is empty, false otherwise.
	public boolean empty() {
		return (st1.size() + st2.size()) == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStack myQueue = new QueueUsingStack();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue.peek(); // return 1
		myQueue.pop(); // return 1, queue is [2]
		myQueue.empty(); // return false
	}

}
