package com.algorithms.practice.stack;

public class StackUsingArray {

	// Implement stack operations using array.

	public int capacity;
	public int[] arr;
	public int top;

	public StackUsingArray(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
		this.top = -1;
	}

	// pushes an item to top of stack.
	public void push(int item) {
		if (this.top == this.capacity - 1) {
			System.out.println("Stack Overflow.");
			return;
		}
		this.top++;
		this.arr[this.top] = item;
	}

	// pops the top item form stack and returns that item.
	public int pop() {
		if (this.top == -1) {
			System.out.println("Stack Underflow.");
			return -1;
		}
		int item = this.arr[this.top];
		this.top--;
		return item;
	}

	// returns the top item of the stack.
	public int peek() {
		if (this.top == -1) {
			System.out.println("Stack is Empty.");
			return -1;
		}
		return this.arr[this.top];
	}

	// returns the current size of the stack.
	public int size() {
		return this.top + 1;
	}

	// returns true if stack is empty, else false.
	public boolean isEmpty() {
		if (this.top == -1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingArray s = new StackUsingArray(10);
		s.push(5);
		s.push(15);
		s.push(25);
		System.out.println("The item peeked is: " + s.peek());
		System.out.println("The item popped is: " + s.pop());
		s.push(35);
		System.out.println("The size of the stack is: " + s.size());
		System.out.println("Is stack empty: " + s.isEmpty());
	}

}
