package com.trantbatey.practice.test;

import com.trantbatey.practice.RegEx;

/**
 *
 * @author tbatey
 * 
 *         Original Work Copyright (c) 2017, Trant Walter Batey
 *         trantbatey@gmail.com
 * 
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 * 
 *         Within reason, give the originator credit for the code
 */
public class TestRegEx {

	// @Test
	public static boolean testSuccess_RegEx() {

		// Test successful
		try {
			Assert.assertTrue(RegEx.isMatch("aab", "c*a*b")); 
			Assert.assertTrue(RegEx.isMatch("aaa", "ab*a*c*a"));
			Assert.assertTrue(!RegEx.isMatch("abcd", "d*"));
			Assert.assertTrue(RegEx.isMatch("cbbbaccbcacbcca", "b*.*b*a*.a*b*.a*"));
		} catch (Exception e) {
			return false;
		}

		return true;
	}
}