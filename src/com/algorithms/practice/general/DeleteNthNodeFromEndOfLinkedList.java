package com.algorithms.practice.general;

import com.algorithms.practice.linkedlist.Node;

public class DeleteNthNodeFromEndOfLinkedList {

	// Given the head of a linked list, remove the nth node from the end of the list
	// and return its head.

	// The number of nodes in the list is sz.
	// 1 <= sz <= 30
	// 0 <= Node.val <= 100
	// 1 <= n <= sz

	// Follow up: Could you do this in one pass?

	// efficient solution.
	public Node removeNthFromEnd(Node head, int n) {
		if (head == null || head.next == null) {
			return null;
		}
		Node slow = head;
		int count = 0;
		while (slow != null && count < n) {
			slow = slow.next;
			count++;
		}
		Node fast = slow;
		slow = head;
		if (fast == null) {
			return head.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}

}
