package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

import com.algorithms.practice.linkedlist.Node;

public class RemoveDuplicatesFromUnsortedLinkedList {

	// Given the head of a linked list, find all the values that appear more than
	// once in the list and delete the nodes that have any of those values.

	// Return the linked list after the deletions.

	// efficient solution.
	public Node deleteDuplicatesUnsorted(Node head) {
		Map<Integer, Integer> hmap = new HashMap<>();
		Node curr = head;
		while (curr != null) {
			hmap.put(curr.data, hmap.getOrDefault(curr.data, 0) + 1);
			curr = curr.next;
		}

		Node prev = null;
		curr = head;
		while (curr != null) {
			if (hmap.get(curr.data) == 1) {
				if (prev == null) {
					prev = curr;
					head = prev;
				} else {
					prev.next = curr;
					prev = curr;
				}
			}
			curr = curr.next;
		}
		if (prev != null) {
			prev.next = curr;
		}
		return (prev == null) ? null : head;
	}

}
