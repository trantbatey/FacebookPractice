package com.trantbatey.practice.test;

/**
 *
 * @author tbatey
 * 
 * This is a class for running test on utility class and methods.
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
public class TestRunner {

    /**
     * The main method is used for unit testing the modules of the TMO
     * application
     *
     * @param args unused
     */
    public static void main(String[] args) {

        final boolean TEST_All = true;
        final boolean TEST_Number = false;


        if (TEST_Number || TEST_All) {

            // test the Number Class
            System.out.println("TestNumber.testSuccess_isNumber\n");
            if (TestNumber.testSuccess_isNumber()) {
                System.out.println("TestNumber.testSuccess_isNumber Passed\n\n\n");
            } else {
                System.out.println("*** TestNumber.testSuccess_isNumber Failed ***\n\n\n");
            }
            System.out.println("TestNumber.testSuccess_parseDouble\n");
            if (TestNumber.testSuccess_parseDouble()) {
                System.out.println("TestNumber.testSuccess_parseDouble Passed\n\n\n");
            } else {
                System.out.println("*** TestNumber.testSuccess_parseDouble Failed ***\n\n\n");
            }
        }
    }

}