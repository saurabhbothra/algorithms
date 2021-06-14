package com.algorithms.practice.linkedlist;

public class FirstNodeOfLoop {

	// Given a linked list, return the node where the cycle begins. If there is no
	// cycle, return null.

	// There is a cycle in a linked list if there is some node in the list that can
	// be reached again by continuously following the next pointer.

	// efficient solution.
	public static Node detectCycle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
