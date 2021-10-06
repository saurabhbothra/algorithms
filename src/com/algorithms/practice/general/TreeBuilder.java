package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents this expression.

Postfix notation is a notation for writing arithmetic expressions in which the operands (numbers) appear before their operators. 
For example, the postfix tokens of the expression 4*(5-(7+2)) are represented in the array postfix = ["4","5","7","2","+","-","*"].

The class Node is an interface you should use to implement the binary expression tree. The returned tree will be tested using the evaluate 
function, which is supposed to evaluate the tree's value. You should not remove the Node class; however, you can modify it as you wish, and 
you can define other classes to implement it if needed.

A binary expression tree is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has 
either zero or two children. Leaf nodes (nodes with 0 children) correspond to operands (numbers), and internal nodes (nodes with 
two children) correspond to the operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).

It's guaranteed that no subtree will yield a value that exceeds 109 in absolute value, and all the operations are valid (i.e., 
no division by zero).

Follow up: Could you design the expression tree such that it is more modular? For example, is your design able to support 
additional operators without making changes to your existing evaluate implementation?
 */

abstract class TrNode {
	public abstract int evaluate();
	// define your fields here
};

class Evaluation {
	public static int evaluate(String oper, int num1, int num2) {
		switch (oper) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "/":
			return num1 / num2;
		case "*":
			return num1 * num2;
		}
		return -1;
	}

	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}

class Operand extends TrNode {

	private int num;

	public Operand(int num) {
		this.num = num;
	}

	public int evaluate() {
		return num;
	}
}

class Operator extends TrNode {

	private String oper;
	private List<TrNode> operands;

	public Operator(String oper, TrNode operandA, TrNode operandB) {
		this.oper = oper;
		this.operands = new ArrayList<>();
		this.operands.add(operandA);
		this.operands.add(operandB);
	}

	public int evaluate() {
		int num1 = this.operands.get(0).evaluate();
		int num2 = this.operands.get(1).evaluate();
		int res = Evaluation.evaluate(this.oper, num1, num2);
		return res;
	}
}

public class TreeBuilder {

	public TrNode root;

	public int buildTree(String[] postfix) {
		ArrayDeque<TrNode> st = new ArrayDeque<>();
		for (String i : postfix) {
			if (Evaluation.isNumeric(i)) {
				st.push(new Operand(Integer.parseInt(i)));
			} else {
				TrNode b = st.pop();
				TrNode a = st.pop();
				TrNode operator = new Operator(i, a, b);
				st.push(operator);
			}
		}
		this.root = st.pop();
		return this.root.evaluate();
	}

}
