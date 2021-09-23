package com.algorithms.practice.linkedlist;

public class DoublyLinkedList {

	// Implement doubly linked list operations.

	// Delete at end of a doubly linked list.
	public static DoubleNode deleteAtEnd(DoubleNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		DoubleNode temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}

	// Delete head of doubly linked list.
	public static DoubleNode deleteAtBegin(DoubleNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		DoubleNode curr = head.next;
		curr.prev = null;
		head.next = null;
		return curr;
	}

	// Reverse a doubly linked list.
	public static DoubleNode reverse(DoubleNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		DoubleNode temp = head;
		DoubleNode prev = null;
		while (temp != null) {
			prev = temp.prev;
			temp.prev = temp.next;
			temp.next = prev;
			temp = temp.prev;
		}
		return prev.prev;
	}

	// Reverse a doubly linked list.
	public static DoubleNode reverse2(DoubleNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		DoubleNode prev = null;
		DoubleNode curr = head;
		while (curr != null) {
			DoubleNode temp = curr.next;
			curr.next = prev;
			if (prev != null) {
				prev.prev = curr;
			}
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	// Insert at end of a doubly linked list.
	public static DoubleNode insertAtEnd(DoubleNode head, int data) {
		DoubleNode node = new DoubleNode(data);
		if (head == null) {
			return node;
		}
		DoubleNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		node.prev = temp;
		return head;
	}

	// Insert at beginning of doubly linked list.
	public static DoubleNode insertAtBegin(DoubleNode head, int data) {
		DoubleNode node = new DoubleNode(data);
		if (head == null) {
			return node;
		}
		node.next = head;
		head.prev = node;
		return node;
	}

	// Traversing a doubly linked list in java, iterative.
	public static void display(DoubleNode head) {
		DoubleNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Doubly Linked List is:");
		DoubleNode head = insertAtEnd(null, 30);
		head = insertAtEnd(head, 20);
		head = insertAtEnd(head, 10);
		head = insertAtEnd(head, 5);
		head = insertAtEnd(head, 40);
		display(head);
		head = reverse2(head);
		display(head);
	}

}
