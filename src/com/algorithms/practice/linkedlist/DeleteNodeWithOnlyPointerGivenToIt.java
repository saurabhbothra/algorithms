package com.algorithms.practice.linkedlist;

public class DeleteNodeWithOnlyPointerGivenToIt {

	// Write a function to delete a node in a singly-linked list. You will not be
	// given access to the head of the list, instead you will be given access to the
	// node to be deleted directly.

	// It is guaranteed that the node to be deleted is not a tail node in the list.

	// efficient solution.
	public static void deleteNode(Node node) {
		int data = node.data;
		node.data = node.next.data;
		node.next.data = data;
		node.next = node.next.next;
	}

}
