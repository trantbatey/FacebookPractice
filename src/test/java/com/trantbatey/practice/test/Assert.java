package com.trantbatey.practice.test;


/**
 *
 * @author tbatey
 * 
 * I was working in an environment where JUnit was unavailable. In order to 
 * keep the unit test working, I created a substitute Assert class.
 * 
 * Original Work Copyright (c) 2017, Trant Walter Batey
 * trantbatey@gmail.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * Within reason, give the originator credit for the code
 */
public class Assert {
    
    public static boolean assertTrue(boolean assertion) {
        if (assertion) {
            System.out.println("Test Success");
            return true;
        } else {
            System.out.println("Test Failure");
            return false;
        }
    }
    
    public static boolean assertEquals(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            System.out.println("Test Success");
            return true;
        } else if (o1 == null) {
            System.out.println("Test Failure");
            return false;
        } else if (o2 == null) {
            System.out.println("Test Failure");
            return false;
        } else if (!o1.equals(o2)) {
            System.out.println("Test Success");
            return false;
        } else {
            System.out.println("Test Success");
            return true;
        }
    }
    
    public static boolean assertNotNull(Object o1) {
        if (o1 != null) {
            System.out.println("Test Success");
            return true;
        } else {
            System.out.println("Test Failure");
            return false;
        }
    }
    
    public static boolean assertNull(Object o1) {
        if (o1 == null) {
            System.out.println("Test Success");
            return true;
        } else {
            System.out.println("Test Failure");
            return false;
        }
    }
    
}
