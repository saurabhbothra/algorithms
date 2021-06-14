package com.algorithms.practice.linkedlist;

public class DetectAndRemoveLoopInLinkedList {

	// You are given a linked list of N nodes. Remove the loop from the linked list,
	// if present.

	// efficient solution.
	public static void removeLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		while (fast.next != slow) {
			fast = fast.next;
		}
		fast.next = null;
	}

}
