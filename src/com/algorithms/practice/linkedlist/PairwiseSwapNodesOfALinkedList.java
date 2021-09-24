package com.algorithms.practice.linkedlist;

public class PairwiseSwapNodesOfALinkedList {

	// Given a linked list, swap every two adjacent nodes and return its head. You
	// must solve the problem without modifying the values in the list's nodes
	// (i.e., only nodes themselves may be changed.)

	// efficient solution.
	public static Node swapPairs(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node newHead = null;
		Node newTail = null;
		Node prev = null;
		Node curr = head;
		int count = 1;
		while (curr != null) {
			Node nxt = curr.next;
			if (count % 2 != 0) {
				prev = curr;
			} else {
				if (newHead == null) {
					newHead = curr;
				} else {
					newTail.next = curr;
				}
				newTail = curr;
				newTail.next = prev;
				newTail = prev;
				newTail.next = nxt;
			}
			count++;
			curr = nxt;
		}
		return newHead;
	}

	// iterative, better implementation.
	public static Node swapPairs2(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node tail = null;
		Node curr = head;
		head = null;
		while (curr != null && curr.next != null) {
			Node temp = curr.next.next;
			if (head == null) {
				head = curr.next;
				tail = curr;
				head.next = tail;
			} else {
				tail.next = curr.next;
				tail.next.next = curr;
				tail = curr;
			}
			curr = temp;
		}

		tail.next = curr;
		return head;
	}

	// recursive solution.
	public static Node swapPairsRec(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node temp = head.next.next;
		Node curr = head.next;
		curr.next = head;
		head.next = swapPairsRec(temp);
		return curr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 17);
		head = LinkedList.insertAtBegin(head, 15);
		head = LinkedList.insertAtBegin(head, 13);
		head = LinkedList.insertAtBegin(head, 12);
		head = LinkedList.insertAtBegin(head, 10);
		head = LinkedList.insertAtBegin(head, 5);
		head = LinkedList.insertAtBegin(head, 4);
		System.out.println("The linked list before swapping is:");
		LinkedList.display(head);
		head = swapPairs(head);
		System.out.println("The linked list after swapping is:");
		LinkedList.display(head);
	}

}
