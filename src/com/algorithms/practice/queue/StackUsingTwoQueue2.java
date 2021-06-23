package com.algorithms.practice.queue;

import java.util.ArrayDeque;
import java.util.Queue;

// push - O(n) and pop - O(1)

public class StackUsingTwoQueue2 {

	// Implement a last in first out (LIFO) stack using only two queues. The
	// implemented stack should support all the functions of a normal queue (push,
	// top, pop, and empty).

	public Queue<Integer> q1;
	public Queue<Integer> q2;
	public int top;

	/** Initialize your data structure here. */
	public StackUsingTwoQueue2() {
		this.q1 = new ArrayDeque<>();
		this.q2 = new ArrayDeque<>();
		this.top = -1;
	}

	/** Push element x onto stack. */
	public void push(int x) {
		this.q2.offer(x);
        while(!this.q1.isEmpty()) {
            this.q2.offer(this.q1.poll());
        }
        this.top = x;
        Queue<Integer> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		int item = this.q1.poll();
        if(this.q1.isEmpty()) {
            this.top = -1;
        } else {
            this.top = this.q1.peek();
        }
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
		StackUsingTwoQueue2 st = new StackUsingTwoQueue2();
		st.push(1);
		st.push(2);
		System.out.println(st.top());
		System.out.println(st.pop());
		System.out.println(st.empty());
		System.out.println(st.size());
		System.out.println(st.top());
	}

}
