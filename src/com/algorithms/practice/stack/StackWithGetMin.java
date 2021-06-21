package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class StackWithGetMin {

	// Design a stack that supports push, pop, top, and retrieving the minimum
	// element in constant time.

	// Methods pop, top and getMin operations will always be called on non-empty
	// stacks.

	public ArrayDeque<Integer> mainSt;
	public ArrayDeque<Integer> minSt;

	// initializes your data structure.
	public StackWithGetMin() {
		this.mainSt = new ArrayDeque<>();
		this.minSt = new ArrayDeque<>();
	}

	// pushes the element val onto the stack.
	public void push(int val) {
		this.mainSt.push(val);
		if (this.minSt.isEmpty() || this.minSt.peek() >= val) {
			this.minSt.push(val);
		}
	}

	// removes the element on the top of the stack.
	public void pop() {
		int item = this.mainSt.pop();
		if (item == this.minSt.peek()) {
			this.minSt.pop();
		}
	}

	// gets the top element of the stack.
	public int top() {
		return this.mainSt.peek();
	}

	// retrieves the minimum element in the stack.
	public int getMin() {
		return this.minSt.peek();
	}
}
