package com.algorithms.practice.stack;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {

	// Implement stack operations using array.

	public List<Integer> arr;

	public StackUsingArrayList() {
		this.arr = new ArrayList<>();
	}

	// pushes an item to top of stack.
	public void push(int item) {
		this.arr.add(item);
	}

	// pops the top item form stack and returns that item.
	public int pop() {
		int item = this.arr.get(this.arr.size() - 1);
		this.arr.remove(this.arr.size() - 1);
		return item;
	}

	// returns the top item of the stack.
	public int peek() {
		return this.arr.get(this.arr.size() - 1);
	}

	// returns the current size of the stack.
	public int size() {
		return this.arr.size();
	}

	// returns true if stack is empty, else false.
	public boolean isEmpty() {
		return this.arr.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingArrayList s = new StackUsingArrayList();
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
