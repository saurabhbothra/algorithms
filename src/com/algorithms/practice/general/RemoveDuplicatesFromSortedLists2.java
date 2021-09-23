package com.algorithms.practice.general;

import com.algorithms.practice.linkedlist.Node;

public class RemoveDuplicatesFromSortedLists2 {

	// Given the head of a sorted linked list, delete all nodes that have duplicate
	// numbers, leaving only distinct numbers from the original list. Return the
	// linked list sorted as well.

	// efficient solution.
	public Node deleteDuplicates(Node head) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			if (curr.next == null || curr.next.data != curr.data) {
				if (prev == null) {
					prev = curr;
					head = prev;
				} else {
					prev.next = curr;
					prev = curr;
				}
				curr = curr.next;
			} else {
				Node temp = curr.next;
				while (temp != null && temp.data == curr.data) {
					temp = temp.next;
				}
				curr = temp;
			}
		}
		if (prev != null) {
			prev.next = curr;
		}
		return prev == null ? null : head;
	}
}
