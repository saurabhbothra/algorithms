package com.algorithms.practice.linkedlist;

public class SortedInsertInASinglyLinkedList {

	// Given a sorted singly linked list and an item x, we need to insert x
	// such that the final linked list remains sorted.

	// efficient solution.
	public static Node insertSorted(Node head, int x) {
		Node node = new Node(x);
		if (head == null) {
			return node;
		}
		if (node.data < head.data) {
			node.next = head;
			return node;
		}
		Node temp = head;
		while (temp.next != null && temp.next.data < node.data) {
			temp = temp.next;
		}
		Node curr = temp.next;
		temp.next = node;
		node.next = curr;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 40);
		head = LinkedList.insertAtBegin(head, 30);
		head = LinkedList.insertAtBegin(head, 20);
		head = LinkedList.insertAtBegin(head, 10);
		System.out.println("The sorted linked list before insertion is:");
		LinkedList.display(head);
		head = insertSorted(head, 25);
		System.out.println("The sorted linked list after insertion is:");
		LinkedList.display(head);
	}

}
