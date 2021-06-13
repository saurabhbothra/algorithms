package com.algorithms.practice.linkedlist;

public class ReverseALinkedList {

	// Given the head of a singly linked list, reverse the list, and return the
	// reversed list.

	// efficient solution, iterative.
	public static Node reverseIterative(Node head) {
		if (head == null) {
			return null;
		}
		Node temp = null;
		Node x = head;
		while (x != null) {
			Node curr = x.next;
			x.next = temp;
			temp = x;
			x = curr;
		}
		return temp;
	}

	// efficient solution, recursive 2
	public static Node recursiveSecond(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node newHead = recursiveSecond(head.next);
		Node tail = head.next;
		head.next = null;
		tail.next = head;
		return newHead;
	}

	// efficient solution, recursive 1
	public static Node reverseRecursive(Node head) {
		return reverse(head, null);
	}

	// helper method to reverse linked list.
	public static Node reverse(Node head, Node prev) {
		if (head == null) {
			return prev;
		}
		Node curr = head.next;
		head.next = prev;
		prev = reverse(curr, head);
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 5);
		head = LinkedList.insertAtBegin(head, 4);
		head = LinkedList.insertAtBegin(head, 3);
		head = LinkedList.insertAtBegin(head, 2);
		head = LinkedList.insertAtBegin(head, 1);
		System.out.println("The linked list before reverse is:");
		LinkedList.display(head);
		head = reverseIterative(head);
		System.out.println("The linked list after reverse is:");
		LinkedList.display(head);
	}

}
