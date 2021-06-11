package com.algorithms.practice.linkedlist;

public class LinkedList {

	// Implement Linked List operations.

	// Search in a singly linked list, recursive.
	public static int searchRecursive(Node head, int x) {
		return searchRec(head, x, 1);
	}

	// helper method for search recursive.
	private static int searchRec(Node node, int x, int count) {
		if (node == null) {
			return -1;
		}
		if (node.data == x) {
			return count;
		}
		return searchRec(node.next, x, count + 1);
	}

	// Search in a singly linked list, iterative.
	public static int searchIterative(Node head, int x) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			if (temp.data == x) {
				return count;
			}
			temp = temp.next;
		}
		return -1;
	}

	// Insert at given position in a singly linked list.
	public static Node insertAtPosition(Node head, int position, int x) {
		if (head == null) {
			return head;
		}
		if (position == 1) {
			return insertAtBegin(head, x);
		}
		int count = 2;
		Node temp = head;
		while (temp != null) {
			if (position == count) {
				Node curr = temp.next;
				Node node = new Node(x);
				node.next = curr;
				temp.next = node;
				break;
			}
			temp = temp.next;
			count++;
		}
		return head;
	}

	// Delete at end of the singly linked list.
	public static Node deleteAtEnd(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}

	// Delete at beginning of singly linked list.
	public static Node deleteAtBegin(Node head) {
		if (head == null) {
			return null;
		}
		Node temp = head.next;
		head.next = null;
		head = temp;
		return head;
	}

	// Insert at end of singly linked list.
	public static Node insertAtEnd(Node head, int x) {
		Node node = new Node(x);
		if (head == null) {
			return node;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		return head;
	}

	// Insert at beginning of singly linked list.
	public static Node insertAtBegin(Node head, int x) {
		Node node = new Node(x);
		node.next = head;
		return node;
	}

	// Traversing a singly linked list in java, recursive.
	public static void displayRecursive(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		displayRecursive(node.next);
	}

	// Traversing a singly linked list in java, iterative.
	public static void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = null;
		head = insertAtEnd(head, 10);
		head = insertAtEnd(head, 20);
		head = insertAtEnd(head, 30);
		head = insertAtEnd(head, 40);
		System.out.println("The linked list is: ");
		display(head);
	}

}
