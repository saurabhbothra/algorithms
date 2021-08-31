package com.algorithms.practice.bitmagic;

public class CountSetBits {

	// Given a non-negative integer, count number of one's in its binary
	// representation.

	public int[] table;

	public CountSetBits() {
		this.table = new int[256];
		this.initialize();
	}

	// simple solution.
	public static int countSetBitsSimple(int n) {
		int count = 0;
		while (n > 0) {
			count = count + (n & 1);
			n = n >> 1;
		}
		return count;
	}

	// brian and kerningham algorithm.
	public static int countSetBitsAlgo(int n) {
		int res = 0;
		while (n > 0) {
			n = n & (n - 1);
			res++;
		}
		return res;
	}

	// efficient solution, using lookup table.
	public int countSetBitsEfficient(int n) {
		int res = this.table[n & 0xff];
		n = n >> 8;
		res += this.table[n & 0xff];
		n = n >> 8;
		res += this.table[n & 0xff];
		n = n >> 8;
		res += this.table[n & 0xff];
		n = n >> 8;
		return res;
	}

	public void initialize() {
		this.table[0] = 0;
		for (int i = 1; i < this.table.length; i++) {
			table[i] = (i & 1) + table[i / 2];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountSetBits cs = new CountSetBits();
		System.out.println("The total number of set bits are: " + countSetBitsSimple(39));
		System.out.println("The total number of set bits are: " + countSetBitsAlgo(39));
		System.out.println("The total number of set bits are: " + cs.countSetBitsEfficient(39));
	}

}
