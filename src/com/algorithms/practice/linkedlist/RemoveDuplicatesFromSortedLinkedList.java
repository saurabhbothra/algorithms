package com.algorithms.practice.linkedlist;

public class RemoveDuplicatesFromSortedLinkedList {

	// Given the head of a sorted linked list, delete all duplicates such that each
	// element appears only once. Return the linked list sorted as well.

	// efficient solution.
	public static Node deleteDuplicates(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node curr = head;
		for (Node temp = head.next; temp != null; temp = temp.next) {
			if (temp.data != curr.data) {
				curr.next = temp;
				curr = temp;
			}
		}
		curr.next = null;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 5);
		head = LinkedList.insertAtBegin(head, 3);
		head = LinkedList.insertAtBegin(head, 3);
		head = LinkedList.insertAtBegin(head, 1);
		head = LinkedList.insertAtBegin(head, 1);
		System.out.println("The linked list before deleting duplicates is:");
		LinkedList.display(head);
		head = deleteDuplicates(head);
		System.out.println("The linked list after deleting duplicates is:");
		LinkedList.display(head);
	}

}
