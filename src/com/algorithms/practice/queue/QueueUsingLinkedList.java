package com.algorithms.practice.queue;

import com.algorithms.practice.linkedlist.Node;

public class QueueUsingLinkedList {

	// Implement queue operations using linked list.

	public int capacity;
	public Node head;
	public Node tail;
	public int count;

	// initialize your data structure.
	public QueueUsingLinkedList(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		this.head = null;
		this.tail = null;
	}

	// adds an item to the back of the queue and returns true if operation was
	// successful.
	public boolean enqueue(int item) {
		if (this.count == this.capacity) {
			return false;
		}
		Node newNode = new Node(item);
		if (this.head == null) {
			this.head = newNode;
			this.tail = this.head;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.count++;
		return true;
	}

	// pops an item from front of the queue and returns true if operation was
	// successful.
	public boolean dequeue() {
		if (this.count == 0) {
			return false;
		}
		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
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
		if (this.count == 0) {
			return -1;
		}
		return this.head.data;
	}

	// gets the last item of the queue.
	public int getLast() {
		if (this.count == 0) {
			return -1;
		}
		return this.tail.data;
	}

	// checks whether queue is empty or not.
	public boolean isEmpty() {
		if (this.count == 0) {
			return true;
		}
		return false;
	}

	// checks whether queue has reached it full capacity or not.
	public boolean isFull() {
		if (this.count == this.capacity) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingLinkedList q = new QueueUsingLinkedList(3);
		System.out.println(q.enqueue(1));
		System.out.println(q.enqueue(2));
		System.out.println(q.enqueue(3));
		System.out.println(q.enqueue(4));
		System.out.println(q.getLast());
		System.out.println(q.isFull());
		System.out.println(q.dequeue());
		System.out.println(q.enqueue(4));
		System.out.println(q.getLast());
		System.out.println(q.size());
	}

}
