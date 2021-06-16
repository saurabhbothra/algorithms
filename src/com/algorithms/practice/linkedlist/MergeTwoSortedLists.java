package com.algorithms.practice.linkedlist;

public class MergeTwoSortedLists {

	// Merge two sorted linked lists and return it as a sorted list. The list should
	// be made by splicing together the nodes of the first two lists.

	// efficient solution.
	public static Node mergeTwoSortedLists(Node l1, Node l2) {
		if (l1 == null || l2 == null) {
			return (l1 == null) ? l2 : l1;
		}
		Node temp1 = l1;
		Node temp2 = l2;
		Node head = null;
		Node tail = null;
		while (temp1 != null && temp2 != null) {
			Node curr = null;
			if (temp1.data <= temp2.data) {
				curr = temp1;
				temp1 = temp1.next;
			} else {
				curr = temp2;
				temp2 = temp2.next;
			}
			if (head == null) {
				head = curr;
				tail = head;
			} else {
				tail.next = curr;
				tail = curr;
			}
		}

		tail.next = (temp1 != null) ? temp1 : temp2;
		return head;
	}

}
