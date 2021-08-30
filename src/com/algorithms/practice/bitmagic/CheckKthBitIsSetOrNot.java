package com.algorithms.practice.bitmagic;

public class CheckKthBitIsSetOrNot {

	// Given a number N and a bit number K, check if Kth bit of N is set or not. A
	// bit is called set if it is 1. Position of set bit '1' should be indexed
	// starting with 0 from LSB side in binary representation of the number.

	// efficient solution, using left shif operator.
	public static boolean checkKthBit(int n, int k) {
		int temp = 1 << k;
		return (n & temp) != 0;
	}

	// efficient solution, using right shift operator.
	public static boolean checkKthBitEff(int n, int k) {
		n = n >> k;
		return (n & 1) == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is Kth bit set or not: " + checkKthBit(4, 2));
		System.out.println("Is Kth bit set or not: " + checkKthBitEff(4, 2));
	}

}
