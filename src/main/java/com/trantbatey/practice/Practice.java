package com.trantbatey.practice;

public class Practice {

	public static void main(String[] args) {
		
		// Test Number class
		System.out.println(" ===== Number test! ===== ");
		System.out.println("\"0e19\":\t" + Number.isNumber("0e19"));
		System.out.println("\"0e\":\t" + Number.isNumber("0e"));
		
		// Test RegEx class
		System.out.println("\n\n\n ==== RegEx test! =====");
		System.out.println("\"aab\", \"c*a*b\"\t" + RegEx.isMatch("aab", "c*a*b"));
		System.out.println("\"aaa\", \"ab*a*c*a\"\t" + RegEx.isMatch("aaa", "ab*a*c*a"));
		System.out.println("\"abcd\", \"d*\"\t" + RegEx.isMatch("abcd", "d*"));
		System.out.println("\"cbbbaccbcacbcca\", \"b*.*b*a*.a*b*.a*\"\t" + RegEx.isMatch("cbbbaccbcacbcca", "b*.*b*a*.a*b*.a*"));		
	}
}