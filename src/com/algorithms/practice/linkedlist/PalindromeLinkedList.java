package com.algorithms.practice.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

	// Given the head of a singly linked list, return true if it is a palindrome.

	// naive solution.
	public static boolean isPalindromeNaive(Node head) {
		List<Integer> nodeList = new ArrayList<>();
		Node temp = head;
		while (temp != null) {
			nodeList.add(temp.data);
			temp = temp.next;
		}
		int start = 0;
		int end = nodeList.size() - 1;
		while (start < end) {
			if (nodeList.get(start) != nodeList.get(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	// efficient solution.
	public static boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		Node prev = null;
		while (fast != null && fast.next != null) {
			Node curr = slow.next;
			if (prev == null) {
				prev = slow;
				prev.next = null;
			} else {
				slow.next = prev;
				prev = slow;
			}
			if (fast == slow) {
				fast = curr.next;
			} else {
				fast = fast.next.next;
			}
			slow = curr;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null && prev != null) {
			if (slow.data != prev.data) {
				return false;
			}
			slow = slow.next;
			prev = prev.next;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.insertAtBegin(null, 1);
		head = LinkedList.insertAtBegin(head, 2);
		head = LinkedList.insertAtBegin(head, 2);
		head = LinkedList.insertAtBegin(head, 1);
		System.out.println("The linked list is:");
		LinkedList.display(head);
		boolean isPalindrome = isPalindrome(head);
		System.out.println("Is given linked list palindrome: " + isPalindrome);
	}

}
