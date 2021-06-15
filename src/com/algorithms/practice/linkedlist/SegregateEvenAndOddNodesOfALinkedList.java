package com.algorithms.practice.linkedlist;

public class SegregateEvenAndOddNodesOfALinkedList {

	// Given a singly linked list, the task is to segregate or separate the even and
	// odd nodes of the linked list.

	// efficient solution.
	public static Node oddEvenList(Node head) {
		if (head == null) {
			return null;
		}
		Node even = null;
		Node evenHead = null;
		;
		Node odd = null;
		Node oddHead = null;
		Node curr = head;
		while (curr != null) {
			Node nxt = curr.next;
			if (curr.data % 2 != 0) {
				if (oddHead == null) {
					oddHead = curr;
					odd = curr;
				} else {
					odd.next = curr;
					odd = curr;
				}
			} else {
				if (evenHead == null) {
					evenHead = curr;
					even = curr;
				} else {
					even.next = curr;
					even = curr;
				}
			}
			curr = nxt;
		}
		if (evenHead == null || oddHead == null) {
			return head;
		}
		even.next = oddHead;
		odd.next = null;
		return evenHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 17);
		head = LinkedList.insertAtBegin(head, 15);
		head = LinkedList.insertAtBegin(head, 13);
		head = LinkedList.insertAtBegin(head, 12);
		head = LinkedList.insertAtBegin(head, 10);
		head = LinkedList.insertAtBegin(head, 5);
		head = LinkedList.insertAtBegin(head, 4);
		System.out.println("The linked list before segregation is:");
		LinkedList.display(head);
		head = oddEvenList(head);
		System.out.println("The linked list after segregation is:");
		LinkedList.display(head);
	}

}
