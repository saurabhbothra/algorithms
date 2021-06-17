package com.algorithms.practice.stack;

import com.algorithms.practice.linkedlist.Node;

public class StackUsingLinkedList {

	// Implement stack operations using linked list.

	public Node head;
	public int size;

	public StackUsingLinkedList() {
		this.head = null;
		this.size = 0;
	}

	// pushes an item to top of stack.
	public void push(int item) {
		Node newNode = new Node(item);
		newNode.next = this.head;
		this.head = newNode;
		this.size++;
	}

	// pops the top item form stack and returns that item.
	public int pop() {
		if (this.head == null) {
			System.out.println("Stack Underflow.");
			return -1;
		}
		int item = this.head.data;
		this.head = this.head.next;
		this.size--;
		return item;
	}

	// returns the top item of the stack.
	public int peek() {
		if (this.head == null) {
			System.out.println("Stack is Empty.");
			return -1;
		}
		return this.head.data;
	}

	// returns the current size of the stack.
	public int size() {
		return this.size;
	}

	// returns true if stack is empty, else false.
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingLinkedList s = new StackUsingLinkedList();
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
