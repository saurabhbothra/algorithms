package com.algorithms.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

	// Given the heads of two singly linked-lists headA and headB, return the node
	// at which the two lists intersect. If the two linked lists have no
	// intersection at all, return null.

	// It is guaranteed that there are no cycles anywhere in the entire linked
	// structure.

	// Note that the linked lists must retain their original structure after the
	// function returns.

	// efficient solution 1, hashing
	public static Node getIntersectionNode(Node headA, Node headB) {
		Set<Node> hset = new HashSet<>();
		Node tempA = headA;
		Node tempB = headB;
		while (tempA != null) {
			hset.add(tempA);
			tempA = tempA.next;
		}
		while (tempB != null) {
			if (hset.contains(tempB)) {
				return tempB;
			}
			tempB = tempB.next;
		}
		return null;
	}

	// efficient solution, no extra space.
	public static Node getIntersectionNodeEfficient(Node headA, Node headB) {
		int lengthA = 0;
		int lengthB = 0;
		Node tempA = headA;
		Node tempB = headB;
		while (tempA != null) {
			lengthA++;
			tempA = tempA.next;
		}
		while (tempB != null) {
			lengthB++;
			tempB = tempB.next;
		}
		int diff = Math.abs(lengthA - lengthB);
		if (lengthA > lengthB) {
			tempA = headA;
			tempB = headB;
		} else {
			tempA = headB;
			tempB = headA;
		}
		lengthA = 0;
		while (lengthA < diff) {
			lengthA++;
			tempA = tempA.next;
		}
		while (tempA != null) {
			if (tempA == tempB) {
				return tempA;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}
		return null;
	}
}
