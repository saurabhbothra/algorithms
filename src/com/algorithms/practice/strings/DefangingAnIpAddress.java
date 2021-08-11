package com.algorithms.practice.strings;

public class DefangingAnIpAddress {

	// Given a valid (IPv4) IP address, return a defanged version of that IP
	// address.

	// A defanged IP address replaces every period "." with "[.]".

	// efficient implementation.
	public static String defangIPaddr(String address) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < address.length(); i++) {
			if (address.charAt(i) == '.') {
				sb.append("[.]");
			} else {
				sb.append(address.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1.1.1.1";
		System.out.println("The defanged ip address is: " + defangIPaddr(s));
	}

}
