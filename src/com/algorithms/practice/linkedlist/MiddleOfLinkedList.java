package com.algorithms.practice.linkedlist;

public class MiddleOfLinkedList {

	// Given a non-empty, singly linked list with head node head, return a middle
	// node of linked list.
	// If there are two middle nodes, return the second middle node.

	// naive Solution.
	public static Node middleOfLinkedListNaive(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		int middleNodeIndex = count / 2;
		count = 0;
		temp = head;
		while (count < middleNodeIndex) {
			temp = temp.next;
			count++;
		}
		return temp;
	}

	// efficient solution.
	public static Node middleOfLinkedList(Node head) {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 5);
		head = LinkedList.insertAtBegin(head, 4);
		head = LinkedList.insertAtBegin(head, 3);
		head = LinkedList.insertAtBegin(head, 2);
		head = LinkedList.insertAtBegin(head, 1);
		System.out.println("The linked list is:");
		LinkedList.display(head);
		Node middleNode = middleOfLinkedList(head);
		System.out.println("The middle of linked list is: " + middleNode.data);
	}

}
