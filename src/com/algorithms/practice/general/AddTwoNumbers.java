package com.algorithms.practice.general;

import com.algorithms.practice.linkedlist.Node;

public class AddTwoNumbers {

	// You are given two non-empty linked lists representing two non-negative
	// integers. The digits are stored in reverse order, and each of their nodes
	// contains a single digit. Add the two numbers and return the sum as a linked
	// list.

	// You may assume the two numbers do not contain any leading zero, except the
	// number 0 itself.

	// efficient solution.
	public Node addTwoNumbers(Node l1, Node l2) {
		Node curr1 = l1;
		Node curr2 = l2;
		int carry = 0;
		Node dummy = new Node(-1);
		Node tail = dummy;
		while (curr1 != null && curr2 != null) {
			int num = curr1.data + curr2.data + carry;
			tail.next = new Node(num % 10);
			tail = tail.next;
			carry = num / 10;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		while (curr1 != null) {
			int num = curr1.data + carry;
			tail.next = new Node(num % 10);
			tail = tail.next;
			carry = num / 10;
			curr1 = curr1.next;
		}

		while (curr2 != null) {
			int num = curr2.data + carry;
			tail.next = new Node(num % 10);
			tail = tail.next;
			carry = num / 10;
			curr2 = curr2.next;
		}

		if (carry != 0) {
			tail.next = new Node(carry);
			tail = tail.next;
		}

		return dummy.next;
	}

}
