package com.algorithms.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.algorithms.practice.linkedlist.DoubleNode;
import com.algorithms.practice.linkedlist.Node;

// class for doing rough work.

public class demo {

	public int inverseMemo(int[] nums, int k) {
		Integer[][] memo = new Integer[k + 1][nums.length + 1];
		return inversionRec(nums, k, 0, memo);
	}

	public int inversionRec(int[] nums, int k, int index, Integer[][] memo) {
		if (k == 1) {
			memo[k][index] = 1;
		} else if (index == nums.length) {
			memo[k][index] = 0;
		}
		if (memo[k][index] == null) {
			int count = 0;
			for (int i = index + 1; i < nums.length; i++) {
				if (nums[index] > nums[i]) {
					count = count + inversionRec(nums, k - 1, i, memo);
				}
			}
			if (k == 3) {
				count = count + inversionRec(nums, k, index + 1, memo);
			}
			memo[k][index] = count;
		}
		return memo[k][index];
	}

	public int inversionTabulation(int[] nums, int k) {
		int[][] dp = new int[k + 1][nums.length + 1];
		for (int i = 0; i <= nums.length; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= k; i++) {
			for (int j = nums.length - 1; j >= 0; j--) {
				int count = 0;
				for (int a = j + 1; a < nums.length; a++) {
					if (nums[j] > nums[a]) {
						count = count + dp[i - 1][a];
					}
				}
				if (i == 3) {
					count = count + dp[i][j + 1];
				}
				dp[i][j] = count;
			}
		}
		return dp[k][0];
	}

	public static void countDistinctElements(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < k; i++) {
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
		}
		System.out.print(hmap.size() + " ");
		for (int i = k; i < nums.length; i++) {
			if (hmap.get(nums[i - k]) == 1) {
				hmap.remove(nums[i - k]);
			} else {
				hmap.put(nums[i - k], hmap.get(nums[i - k]) - 1);
			}
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
			System.out.print(hmap.size() + " ");
		}
	}

	public int abc(List<Integer> counters) {
		int oper = 0;
		int maxVal = Integer.MIN_VALUE;
		Set<Integer> hset = new HashSet<>();
		int maxIndex = -1;
		for (int i = 0; i < counters.size(); i++) {
			hset.add(counters.get(i));
			if (counters.get(i) > maxVal) {
				maxVal = counters.get(i);
				maxIndex = i;
			}
		}

		while (hset.size() > 1) {
			oper++;
			hset = new HashSet<>();
			int currMax = maxVal;
			int currIndex = maxIndex;
			for (int i = 0; i < counters.size(); i++) {
				if (i != maxIndex) {
					int temp = counters.get(i);
					counters.set(i, temp + 1);
				}
				if (counters.get(i) > currMax) {
					currMax = counters.get(i);
					currIndex = i;
				}
				hset.add(counters.get(i));
			}
			maxVal = currMax;
			maxIndex = currIndex;

		}
		
		
		return oper;

	}
	
	public static DoubleNode reverse(DoubleNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		DoubleNode prev = null;
		DoubleNode curr = head;
		while(curr!= null) {
			DoubleNode temp = curr.next;
			curr.next = prev;
			if(prev != null) {
				prev.prev = curr;
			}
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	// efficient solution, recursive.
	public static Node reverseKGroups(Node head, int k) {
		if(head == null) {
			return null;
		}
		Node prev = null;
		Node curr = head;
		Node tail = null;
		int count = 0;
		while(count < k) {
			Node temp = curr.next;
			if(tail == null) {
				tail = curr;
			}
			curr.next = prev;
			prev = curr;
			curr = temp;
			count++;
		}
		tail.next = reverseKGroups(curr, k);
		return prev;
	}
	
	public static int[] meandering(int[] nums) {
		Arrays.sort(nums);
		int[] result = new int[nums.length];
		int i = 0;
		int j = nums.length - 1;
		int index = 0;
		boolean flag = true;
		while(i <= j) {
			if(flag) {
				result[index] = nums[j];
				j--;
				flag = false;
			} else {
				result[index] = nums[i];
				i++;
				flag = true;
			}
			index++;
		}
		return result;
	}
	
	// efficient solution.
	public static void prevGreaterElement(int[] arr) {
		if(arr.length == 0) {
			return;
		}
		ArrayDeque<Integer> st = new ArrayDeque<>();
		System.out.print(-1 + " ");
		st.push(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			while(!st.isEmpty() && st.peek() <= arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				System.out.print(-1 + " ");
			} else {
				System.out.print(st.peek() + " ");
			}
			st.push(arr[i]);
		}
		System.out.println();
	}
	
	// efficient solution.
	public static String infoxToPrefix(String s) {
		if(s == null || s.equals("")) 
			return s;
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Character> st = new ArrayDeque<>();
		for(int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			int prec = precedence(ch);
			if(prec == -1) {
				sb.append(ch);
			} else if(ch == ')') {
				st.push(ch);
			} else if(ch == '(') {
				while(!st.isEmpty() && st.peek() != ')') {
					sb.append(st.pop());
				}
				st.pop();
			} else {
				while(!st.isEmpty() && precedence(st.peek()) > prec) {
					sb.append(st.pop());
				}
				st.push(ch);
			}
		}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		sb.reverse();
		return sb.toString();
	}

	// helper method to find precedence of a operator.
	public static int precedence(char ch) {
		switch (ch) {
		case '(':
		case ')':
			return 0;
		case '+':
		case '-':
			return 1;
		case '/':
		case '*':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}


	public static void main(String[] args) {
		System.out.println("The prefix expression for given infix string is: " + infoxToPrefix("a*b+c/d"));
		System.out.println("The prefix expression for given infix string is: " + infoxToPrefix("(a-b/c)*(a/k-l)"));
		System.out.println("The prefix expression for given infix string is: " + infoxToPrefix("x+y/z-w*u"));
		System.out.println("The prefix expression for given infix string is: " + infoxToPrefix("(x+y)*(z+w)"));

	}
}
