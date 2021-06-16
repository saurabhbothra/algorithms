package com.algorithms.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

class RandomNode {
	int val;
	RandomNode next;
	RandomNode random;

	RandomNode(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class CloneALinkedListUsingRandomPointer {

	// A linked list of length n is given such that each node contains an additional
	// random pointer, which could point to any node in the list, or null.

	// Construct a deep copy of the list. The deep copy should consist of exactly n
	// brand new nodes, where each new node has its value set to the value of its
	// corresponding original node. Both the next and random pointer of the new
	// nodes should point to new nodes in the copied list such that the pointers in
	// the original list and copied list represent the same list state. None of the
	// pointers in the new list should point to nodes in the original list.

	// For example, if there are two nodes X and Y in the original list, where
	// X.random --> Y, then for the corresponding two nodes x and y in the copied
	// list, x.random --> y.

	// Return the head of the copied linked list.

	// The linked list is represented in the input/output as a list of n nodes. Each
	// node is represented as a pair of [val, random_index] where:

	// val: an integer representing Node.val
	// random_index: the index of the node (range from 0 to n-1) that the random
	// pointer points to, or null if it does not point to any node.
	// Your code will only be given the head of the original linked list.

	// efficient solution, hashing.
	public static RandomNode copyRandomListHashing(RandomNode head) {
		Map<RandomNode, RandomNode> oldToNew = new HashMap<>();
		RandomNode temp = head;
		while (temp != null) {
			oldToNew.put(temp, new RandomNode(temp.val));
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			RandomNode nxt = temp.next;
			RandomNode random = temp.random;
			RandomNode newNode = oldToNew.get(temp);
			newNode.next = nxt == null ? null : oldToNew.get(nxt);
			newNode.random = random == null ? null : oldToNew.get(random);
			temp = temp.next;
		}
		return (head == null) ? null : oldToNew.get(head);
	}

	// efficient solution.
	public static RandomNode copyRandomListEfficient(RandomNode head) {
		RandomNode curr = head;
		while (curr != null) {
			RandomNode nxt = curr.next;
			RandomNode newNode = new RandomNode(curr.val);
			curr.next = newNode;
			newNode.next = nxt;
			curr = nxt;
		}
		curr = head;
		while (curr != null) {
			curr.next.random = (curr.random == null) ? null : curr.random.next;
			curr = curr.next.next;
		}
		RandomNode newHead = null;
		RandomNode newTail = null;
		curr = head;
		while (curr != null) {
			RandomNode nxt = curr.next.next;
			if (newHead == null) {
				newHead = curr.next;
				newTail = newHead;
			} else {
				newTail.next = curr.next;
				newTail = curr.next;
			}
			curr.next = nxt;
			curr = nxt;
		}
		return newHead;
	}

}
