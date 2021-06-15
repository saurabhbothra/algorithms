package com.algorithms.practice.linkedlist;

public class SegregateEvenOddNodesOfLinkedList {

	// Given the head of a singly linked list, group all the nodes with odd indices
	// together followed by the nodes with even indices, and return the reordered
	// list.

	// The first node is considered odd, and the second node is even, and so on.

	// Note that the relative order inside both the even and odd groups should
	// remain as it was in the input.

	// You must solve the problem in O(1) extra space complexity and O(n) time
	// complexity.

	// efficient solution.
	public static Node oddEvenList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node even = head.next;
		Node evenHead = head.next;
		Node odd = head;
		Node curr = even.next;
		int count = 1;
		while (curr != null) {
			Node nxt = curr.next;
			if (count % 2 != 0) {
				odd.next = curr;
				odd = curr;
			} else {
				even.next = curr;
				even = curr;
			}
			curr = nxt;
			count++;
		}
		odd.next = evenHead;
		even.next = null;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 5);
		head = LinkedList.insertAtBegin(head, 4);
		head = LinkedList.insertAtBegin(head, 3);
		head = LinkedList.insertAtBegin(head, 2);
		head = LinkedList.insertAtBegin(head, 1);
		System.out.println("The linked list before segregation is:");
		LinkedList.display(head);
		head = oddEvenList(head);
		System.out.println("The linked list after segregation is:");
		LinkedList.display(head);
	}

}
