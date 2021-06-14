package com.algorithms.practice.linkedlist;

public class ReverseALinkedListInGroupsOfSizeK {

	// Given a singly linked list and a value k, we need to reverse the linked list
	// in groups of size k
	// and return the new head of the linked list.

	// efficient solution, recursive.
	public static Node reverseKGroupsRec(Node head, int k) {
		Node curr = head;
		Node prev = null;
		Node nxt = null;
		int count = 0;
		while (curr != null && count < k) {
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
			count++;
		}
		if (nxt != null) {
			Node rest_head = reverseKGroupsRec(nxt, k);
			head.next = rest_head;
		}
		return prev;
	}

	// efficient solution, iterative.
	public static Node reverseKGroups(Node head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		Node curr = head;
		Node newHead = null;
		Node tail = null;
		Node prev = null;
		int count = 0;
		while (curr != null) {
			Node nxt = curr.next;
			if (count == k) {
				newHead = prev;
				prev = null;
				tail = curr;
			} else if (count != 0 && count % k == 0) {
				head.next = prev;
				prev = null;
				head = tail;
				tail = curr;
			}
			curr.next = prev;
			prev = curr;
			curr = nxt;
			count++;
		}
		if (newHead == null) {
			return prev;
		}
		head.next = prev;
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 60);
		head = LinkedList.insertAtBegin(head, 50);
		head = LinkedList.insertAtBegin(head, 40);
		head = LinkedList.insertAtBegin(head, 30);
		head = LinkedList.insertAtBegin(head, 20);
		head = LinkedList.insertAtBegin(head, 10);
		head = LinkedList.insertAtBegin(head, 5);
		head = LinkedList.insertAtBegin(head, 1);
		System.out.println("The linked list before reverse is:");
		LinkedList.display(head);
		head = reverseKGroups(head, 3);
		System.out.println("The linked list after reverse is:");
		LinkedList.display(head);
	}

}
