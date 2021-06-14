package com.algorithms.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectLoopInLinkedList {

	// Given head, the head of a linked list, determine if the linked list has a
	// cycle in it.

	// There is a cycle in a linked list if there is some node in the list that can
	// be reached again by continuously following the next pointer. Internally, pos
	// is used to denote the index of the node that tail's next pointer is connected
	// to. Note that pos is not passed as a parameter.

	// Return true if there is a cycle in the linked list. Otherwise, return false.

	// naive solution.
	public static boolean hasCycleNaive(Node head) {
		Set<Node> nodeSet = new HashSet<>();
		Node temp = head;
		while (temp != null) {
			if (nodeSet.contains(temp)) {
				return true;
			} else {
				nodeSet.add(temp);
			}
			temp = temp.next;
		}
		return false;
	}

	// efficient solution1, changing references.
	public static boolean hasCycleEfficientReferences(Node head) {
		Node dummy = new Node(-1);
		Node temp = head;
		while (temp != null) {
			Node curr = temp.next;
			if (temp.next == dummy) {
				return true;
			} else {
				temp.next = dummy;
			}
			temp = curr;
		}
		return false;
	}

	// efficient solution1,
	public static boolean hasCycleEfficient(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

}
