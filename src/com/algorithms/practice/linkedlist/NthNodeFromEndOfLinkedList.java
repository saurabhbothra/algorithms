package com.algorithms.practice.linkedlist;

public class NthNodeFromEndOfLinkedList {

	// Find nth node form end of a linked list.

	// naive solution.
	public static Node findNthNodeFromEndNaive(Node head, int n) {
		if (head == null) {
			return null;
		}
		int listLength = 0;
		Node temp = head;
		while (temp != null) {
			listLength++;
			temp = temp.next;
		}
		if (n > listLength) {
			return null;
		}
		temp = head;
		int count = 0;
		while (count < listLength - n) {
			temp = temp.next;
			count++;
		}
		return temp;
	}

	// efficient solution.
	public static Node findNthNodeFromEnd(Node head, int n) {
		if (head == null) {
			return null;
		}
		Node fast = head;
		Node slow = head;
		for (int i = 0; i < n; i++) {
			if (fast == null) {
				return null;
			}
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 50);
		head = LinkedList.insertAtBegin(head, 40);
		head = LinkedList.insertAtBegin(head, 30);
		head = LinkedList.insertAtBegin(head, 20);
		head = LinkedList.insertAtBegin(head, 10);
		System.out.println("The linked list is:");
		LinkedList.display(head);
		Node nthNode = findNthNodeFromEnd(head, 3);
		if (nthNode == null) {
			System.out.println("There is no nth node from end of linked list.");
		} else {
			System.out.println("The nth node from end of linked list is: " + nthNode.data);
		}
	}

}
