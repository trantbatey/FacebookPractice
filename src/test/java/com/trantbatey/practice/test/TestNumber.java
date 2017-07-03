package com.trantbatey.practice.test;

import com.trantbatey.practice.Number;

/**
 *
 * @author tbatey
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
public class TestNumber {

    //@Test
    public static boolean testSuccess_isNumber() {

        // Test successful 
        try {
            Assert.assertTrue(!Number.isNumber(null));
            Assert.assertTrue(!Number.isNumber("     "));
            Assert.assertTrue(!Number.isNumber("e"));
            Assert.assertTrue(!Number.isNumber("E     "));
            Assert.assertTrue(!Number.isNumber("983.78e0 Is a number"));
            Assert.assertTrue(!Number.isNumber("983.78.0"));
            Assert.assertTrue(!Number.isNumber("983e.78.0"));
            Assert.assertTrue(!Number.isNumber("983.0e78E14"));
            Assert.assertTrue(!Number.isNumber("Non-Digit"));
            Assert.assertTrue(!Number.isNumber("0e")); // no digit after e
            Assert.assertTrue(Number.isNumber("1"));
            Assert.assertTrue(Number.isNumber("1.0"));
            Assert.assertTrue(Number.isNumber("0.1"));
            Assert.assertTrue(Number.isNumber(".1"));
            Assert.assertTrue(Number.isNumber("1."));
            Assert.assertTrue(Number.isNumber("13.476"));
            Assert.assertTrue(Number.isNumber("19"));
            Assert.assertTrue(Number.isNumber("0e19"));
            Assert.assertTrue(Number.isNumber("3.78e0"));
            Assert.assertTrue(Number.isNumber("-1"));
            Assert.assertTrue(Number.isNumber("-1.0"));
            Assert.assertTrue(Number.isNumber("-0.1"));
            Assert.assertTrue(Number.isNumber("-.1"));
            Assert.assertTrue(Number.isNumber("-1."));
            Assert.assertTrue(Number.isNumber("-13.476"));
            Assert.assertTrue(Number.isNumber("-19"));
            Assert.assertTrue(Number.isNumber("-0e19"));
            Assert.assertTrue(Number.isNumber("-3.78e0"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //@Test
    public static boolean testSuccess_parseDouble() {

        // test double sample
        for (int i = 0; i < 3000000; i += 13046) {
            for (int j = 3; j < 50000000; j += 29049) {
                String s = Integer.toString(i) + "." + Integer.toString(j);
                if (Number.parseDouble(s) != Double.parseDouble(s)) {
                    return false;
                }
            }
        }

        // test double precision limits
        double limit = 1.0E-15;
        for (int i = 0; i < 300000000; i += 13046000) {
            for (int j = 3; j < 500000000; j += 29049000) {
                String s = Integer.toString(i) + "." + Integer.toString(j);

                // positive
                double v1 = Number.parseDouble(s);
                double v2 = Double.parseDouble(s);
                double diff = Math.abs(v1 - v2);
                if (diff / v1 > limit) {
                    return false;
                }

                // negitive 
                v1 = Number.parseDouble("-" + s);
                v2 = Double.parseDouble("-" + s);
                diff = Math.abs(v1 - v2);
                if (diff / v1 > limit) {
                    return false;
                }
            }
        }

        // test exponetial notation
        for (int i = 0; i < 30; ++i) {
            String s = "3.78e" + Integer.toString(i);

            // positive
            double v1 = Number.parseDouble(s);
            double v2 = Double.parseDouble(s);
            double diff = Math.abs(v1 - v2);
            if (diff / v1 > limit) {
                return false;
            }

            // negitive 
            v1 = Number.parseDouble("-" + s);
            v2 = Double.parseDouble("-" + s);
            diff = Math.abs(v1 - v2);
            if (diff / v1 > limit) {
                return false;
            }
        }
        for (int i = 0; i < 30; ++i) {
            String s = "3.78e+" + Integer.toString(i);

            // positive
            double v1 = Number.parseDouble(s);
            double v2 = Double.parseDouble(s);
            double diff = Math.abs(v1 - v2);
            if (diff / v1 > limit) {
                return false;
            }

            // negitive 
            v1 = Number.parseDouble("-" + s);
            v2 = Double.parseDouble("-" + s);
            diff = Math.abs(v1 - v2);
            if (diff / v1 > limit) {
                return false;
            }
        }
        for (int i = 0; i < 29; ++i) {
            String s = "3.78e-" + Integer.toString(i);

            // positive
            double v1 = Number.parseDouble(s);
            double v2 = Double.parseDouble(s);
            double diff = Math.abs(v1 - v2);
            if (diff / v1 > limit) {
                return false;
            }

            // negitive 
            v1 = Number.parseDouble("-" + s);
            v2 = Double.parseDouble("-" + s);
            diff = Math.abs(v1 - v2);
            if (diff / v1 > limit) {
                return false;
            }
        }
        return true;
    }

}
