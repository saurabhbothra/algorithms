package com.algorithms.practice.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingTwoQueue {

	// Implement a last in first out (LIFO) stack using only two queues. The
	// implemented stack should support all the functions of a normal queue (push,
	// top, pop, and empty).

	public Queue<Integer> q1;
	public Queue<Integer> q2;
	public int top;

	/** Initialize your data structure here. */
	public StackUsingTwoQueue() {
		this.q1 = new ArrayDeque<>();
		this.q2 = new ArrayDeque<>();
		this.top = -1;
	}

	/** Push element x onto stack. */
	public void push(int x) {
		this.q1.offer(x);
		this.top = x;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		int prevTop = -1;
		while (!this.q1.isEmpty() && this.q1.size() != 1) {
			prevTop = this.q1.poll();
            this.q2.offer(prevTop);
		}
		this.top = prevTop;
		int item = this.q1.poll();
		Queue<Integer> temp = this.q1;
		this.q1 = this.q2;
		this.q2 = temp;
		return item;
	}

	/** Get the top element. */
	public int top() {
		return this.top;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return this.q1.isEmpty();
	}

	/** Returns the size of the stack. */
	public int size() {
		return this.q1.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingTwoQueue st = new StackUsingTwoQueue();
		st.push(1);
		st.push(2);
		System.out.println(st.top());
		System.out.println(st.pop());
		System.out.println(st.empty());
		System.out.println(st.size());
	}

}
