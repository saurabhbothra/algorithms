package com.algorithms.practice.linkedlist;

public class CircularLinkedList {

	// Implement circular linked list operations.

	// Delete kth node from beginning of a circular linked list.
	public static CircularNode deleteAtK(CircularNode head, int k) {
		if (head == null) {
			return null;
		}
		if (k == 1) {
			return deleteAtBeginEfficient(head);
		}
		int count = 2;
		CircularNode temp = head;
		while (count != k && temp.next != head) {
			temp = temp.next;
			count++;
		}
		temp.next = temp.next.next;
		return head;
	}

	// Delete at beginning of circular linked list, efficient solution.
	public static CircularNode deleteAtBeginEfficient(CircularNode head) {
		if (head == null || head.next == head) {
			return null;
		}
		CircularNode curr = head.next;
		int data = curr.data;
		curr.data = head.data;
		head.data = data;
		head.next = curr.next;
		return head;
	}

	// Delete at beginning of circular linked list.
	public static CircularNode deleteAtBegin(CircularNode head) {
		if (head == null || head.next == head) {
			return null;
		}
		CircularNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = head.next;
		return head.next;
	}

	// Insert at the end of circular linked list, efficient solution.
	public static CircularNode insertAtEndEfficient(CircularNode head, int x) {
		CircularNode node = new CircularNode(x);
		if (head == null) {
			node.next = node;
			return node;
		}
		node.data = head.data;
		head.data = x;
		CircularNode curr = head.next;
		head.next = node;
		node.next = curr;
		return head.next;
	}

	// Insert at the end of circular linked list.
	public static CircularNode insertAtEnd(CircularNode head, int x) {
		CircularNode node = new CircularNode(x);
		if (head == null) {
			node.next = node;
			return node;
		}
		CircularNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = node;
		node.next = head;
		return head;
	}

	// Insert at beginning of circular linked list, efficient solution.
	public static CircularNode insertAtBeginEfficient(CircularNode head, int x) {
		CircularNode node = new CircularNode(x);
		if (head == null) {
			node.next = node;
			return node;
		}
		node.data = head.data;
		head.data = x;
		CircularNode temp = head.next;
		head.next = node;
		node.next = temp;
		return head;
	}

	// Insert at beginning of circular linked list.
	public static CircularNode insertAtBegin(CircularNode head, int x) {
		CircularNode node = new CircularNode(x);
		if (head == null) {
			node.next = node;
			return node;
		}
		CircularNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = node;
		node.next = head;
		return node;
	}

	// Traverse a circular linked list.
	public static void display(CircularNode head) {
		if (head == null) {
			return;
		}
		CircularNode temp = head;
		while (temp.next != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularNode head = insertAtEndEfficient(null, 40);
		head = insertAtEndEfficient(head, 30);
		head = insertAtEndEfficient(head, 20);
		head = insertAtEndEfficient(head, 10);
		head = insertAtEndEfficient(head, 5);
		System.out.println("The circular linked list is:");
		display(head);
	}

}
