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

	// better iterative implementation.
	public Node mergeTwoLists(Node l1, Node l2) {
		Node curr1 = l1;
		Node curr2 = l2;
		Node head = new Node(-1);
		Node tail = head;
		while (curr1 != null && curr2 != null) {
			if (curr1.data <= curr2.data) {
				tail.next = curr1;
				curr1 = curr1.next;
			} else {
				tail.next = curr2;
				curr2 = curr2.next;
			}
			tail = tail.next;
		}

		if (curr1 == null) {
			tail.next = curr2;
		} else {
			tail.next = curr1;
		}
		return head.next;
	}

	// recursive implementation.
	public Node mergeTwoListsRec(Node l1, Node l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		if (l1.data <= l2.data) {
			l1.next = mergeTwoListsRec(l1.next, l2);
			return l1;
		}

		l2.next = mergeTwoListsRec(l1, l2.next);
		return l2;
	}

}
