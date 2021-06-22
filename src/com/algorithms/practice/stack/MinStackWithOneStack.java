package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class MinStackWithOneStack {

	// Design a stack that supports push, pop, top, and retrieving the minimum
	// element in constant time.

	// Methods pop, top and getMin operations will always be called on non-empty
	// stacks.

	public ArrayDeque<int[]> mainSt;

	// initializes your data structure.
	public MinStackWithOneStack() {
		this.mainSt = new ArrayDeque<>();
	}

	// pushes the element val onto the stack.
	public void push(int val) {
		int[] item = new int[2];
		if (this.mainSt.isEmpty() || this.mainSt.peek()[1] >= val) {
			item[0] = val;
			item[1] = val;
		} else {
			item[0] = val;
			item[1] = this.mainSt.peek()[1];
		}
		this.mainSt.push(item);
	}

	// removes the element on the top of the stack.
	public void pop() {
		this.mainSt.pop();
	}

	// gets the top element of the stack.
	public int top() {
		return this.mainSt.peek()[0];
	}

	// retrieves the minimum element in the stack.
	public int getMin() {
		return this.mainSt.peek()[1];
	}

}
