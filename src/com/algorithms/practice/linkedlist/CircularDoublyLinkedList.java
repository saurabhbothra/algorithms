package com.algorithms.practice.linkedlist;

public class CircularDoublyLinkedList {

	// Implement operations in circular doubly linked list.

	// Insert at end of a circular doubly linked list.
	public static CircularDoubleNode insertAtEnd(CircularDoubleNode head, int x) {
		CircularDoubleNode node = new CircularDoubleNode(x);
		if (head == null) {
			node.next = node;
			node.prev = node;
			return node;
		}
		CircularDoubleNode lastNode = head.prev;
		lastNode.next = node;
		node.next = head;
		node.prev = lastNode;
		head.prev = node;
		return head;
	}

	// Insert at beginning of a circular doubly linked list.
	public static CircularDoubleNode insertAtBegin(CircularDoubleNode head, int x) {
		CircularDoubleNode node = new CircularDoubleNode(x);
		if (head == null) {
			node.next = node;
			node.prev = node;
			return node;
		}
		CircularDoubleNode lastNode = head.prev;
		head.prev = node;
		node.next = head;
		node.prev = lastNode;
		lastNode.next = node;
		return node;
	}

	// Traverse a circular doubly linked list.
	public static void display(CircularDoubleNode head) {
		if (head == null) {
			return;
		}
		CircularDoubleNode temp = head;
		while (temp.next != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The circular doubly linked list is:");
		CircularDoubleNode head = insertAtEnd(null, 40);
		head = insertAtEnd(head, 30);
		head = insertAtEnd(head, 20);
		head = insertAtEnd(head, 10);
		head = insertAtEnd(head, 5);
		display(head);
	}

}
