package com.algorithms.practice.general;

import com.algorithms.practice.linkedlist.LinkedList;
import com.algorithms.practice.linkedlist.Node;

public class ReverseNodesInKGroup {

	// Given a linked list, reverse the nodes of a linked list k at a time and
	// return its modified list.

	// k is a positive integer and is less than or equal to the length of the linked
	// list. If the number of nodes is not a multiple of k then left-out nodes, in
	// the end, should remain as it is.

	// You may not alter the values in the list's nodes, only nodes themselves may
	// be changed.

	// Follow-up: Can you solve the problem in O(1) extra memory space?

	// iterative solution.
	public static Node tempHead;
	public static Node tempTail;

	public static Node reverseKGroupIter(Node head, int k) {
		if (head == null) {
			return null;
		}

		Node prev = null;
		Node tail = null;
		Node curr = head;
		Node start = null;
		int count = 1;
		while (curr != null) {
			if (count == 1) {
				start = curr;
			}
			Node fut = curr.next;
			if (count % k == 0) {
				curr.next = null;
				reverse(start);
				if (prev == null) {
					prev = tempHead;
					tail = tempTail;
				} else {
					tail.next = tempHead;
					tail = tempTail;
				}
				count = 0;
				tempHead = null;
				tempTail = null;
			}
			curr = fut;
			count++;
		}
		if (count > 1 && count <= k) {
			tail.next = start;
		}
		return prev;
	}

	private static void reverse(Node startNode) {
		while (startNode != null) {
			Node fut = startNode.next;
			if (tempHead == null) {
				tempHead = startNode;
				tempTail = startNode;
				tempTail.next = null;
			} else {
				startNode.next = tempHead;
				tempHead = startNode;
			}
			startNode = fut;
		}
	}

	// recursive solution.
	public static Node reverseKGroup(Node head, int k) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		int count = 0;
		Node prev = curr;
		Node start = null;
		while (curr != null && count < k) {
			if (count == 0) {
				start = curr;
			}
			prev = curr;
			curr = curr.next;
			count++;
		}
		if (count != k) {
			return start;
		}
		prev.next = null;
		Node[] nodes = reverseRec(start);
		nodes[1].next = reverseKGroup(curr, k);
		return nodes[0];
	}

	private static Node[] reverseRec(Node startNode) {
		Node tempHead = null;
		Node tempTail = null;
		while (startNode != null) {
			Node fut = startNode.next;
			if (tempHead == null) {
				tempHead = startNode;
				tempTail = startNode;
				tempTail.next = null;
			} else {
				startNode.next = tempHead;
				tempHead = startNode;
			}
			startNode = fut;
		}
		return new Node[] { tempHead, tempTail };
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
		// head = LinkedList.insertAtBegin(head, 2);
		System.out.println("The linked list before reverse is:");
		LinkedList.display(head);
		head = reverseKGroupIter(head, 3);
		System.out.println("The linked list after reverse is:");
		LinkedList.display(head);
	}

}
