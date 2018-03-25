package com.trantbatey.practice;

/**
 *
 * @author trantbatey@gmail.com
 * 
 * Fortify has a minor issue. It reports that using "Double.parseDouble(String s)" 
 * can cause a thread to hang. This class was written to resolve the issue. It is 
 * accurate to 1.0E-15. 1.0E-15 (or 16 decimals) is the maximum precision of double 
 * precision numbers.
 * 
 * While I have done everything to the best of my abilities to validate the accuracy 
 * of the methods of this class, I make no guarantees as to it's suitability for your 
 * use. * 
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
public class Number {

   /**
    * Checks if the string is a number.
    *
    * @param s the input string
    * @return true, if is number
    */
   public static boolean isNumber(String s) {

       if (s == null)
           return false;
       int length = s.length();
       int indexStart = 0;

       // skip blanks
       while (s.charAt(indexStart) == ' ') {
           indexStart++;
           if (indexStart == length)
               return false;
       }

       // skip first char '+', '-', or 'e'
       if (s.charAt(indexStart) == '-')
           indexStart++;
       if (s.charAt(indexStart) == '+')
           indexStart++;
       if ((s.charAt(indexStart) == 'e') || (s.charAt(indexStart) == 'E'))
           return false;
       int decimalCount = 0;
       int eCount = 0;

       // main loop
       boolean mustBeBlank = false;
       boolean isNum = false;
       for (int i = indexStart; i < length; ++i) {

           // strip trailing blanks
           if (mustBeBlank) {
               if (s.charAt(i) != ' ')
                   return false;
           } // handle decimal
           else if (s.charAt(i) == '.') {
               decimalCount++;
               if (decimalCount > 1)
                   return false;
           } // ; handle exponential notation
           else if ((s.charAt(i) == 'e') || (s.charAt(i) == 'E')) {
               eCount++;
               decimalCount++; // no decimals after e
               if ((i + 1 < length) && (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+'))
                   ++i;
               if (!isNum)
                   return false;
               isNum = false;
               if (eCount > 1)
                   return false;
           } // test for strat of trailing blanks
           else if (s.charAt(i) == ' ')
               mustBeBlank = true;

           // test for non-digit
           else if ((s.charAt(i) < '0') || (s.charAt(i) > '9'))
               return false;

           // verify that at least one digit exist
           else
               isNum = true;
       }

       return isNum;
   }

   /**
    * Parses the double.
    *
    * @param s the String to convert to double
    *
    * @return the double
    * @throws NumberFormatException the number format exception
    */
   public static double parseDouble(String s) throws NumberFormatException {

       if (s == null)
           throw new NumberFormatException("The string is null");
       double value;
       long iValue = 0;
       int length = s.length();
       int indexStart = 0;
       int exponent = 0;
       int decimalDigits = 0;
       boolean positiveExponent = true;
       boolean positiveNumber = true;
       boolean digitMode = true;

       // skip blanks
       while (s.charAt(indexStart) == ' ') {
           indexStart++;
           if (indexStart == length)
               throw new NumberFormatException("The string is blank");
       }

       // skip first char '+', '-', or 'e'
       if (s.charAt(indexStart) == '-') {
           indexStart++;
           positiveNumber = false;
       }
       if (s.charAt(indexStart) == '+')
           indexStart++;
       if ((s.charAt(indexStart) == 'e') || (s.charAt(indexStart) == 'E'))
           throw new NumberFormatException(s + " is not a valid number");
       int decimalCount = 0;
       int eCount = 0;

       // main loop
       boolean mustBeBlank = false;
       boolean atLeastOne = false;
       for (int i = indexStart; i < length; ++i) {

           // strip trailing blanks
           if (mustBeBlank) {
               if (s.charAt(i) != ' ')
                   throw new NumberFormatException(s + " is not a valid number");
           } // handle decimal
           else if (s.charAt(i) == '.') {
               decimalCount++;
               if (decimalCount > 1)
                   throw new NumberFormatException(s + " is not a valid number");
           } // handle exponential notation
           else if ((s.charAt(i) == 'e') || (s.charAt(i) == 'E')) {
               if (!atLeastOne)
                   throw new NumberFormatException(s + " is not a valid number");
               eCount++;
               decimalCount++; // no decimals after e
               digitMode = false;

               // test for sign
               if (i + 1 < length) {
                   if (s.charAt(i + 1) == '-') {
                       ++i;
                       positiveExponent = false;
                   }
                   if (s.charAt(i + 1) == '+') {
                       ++i;
                       positiveExponent = true;
                   }
               }
               atLeastOne = false;
               if (eCount > 1)
                   throw new NumberFormatException(s + " is not a valid number");
           } // test for start of trailing blanks
           else if (s.charAt(i) == ' ')
               mustBeBlank = true;

           // test for non-digit
           else if ((s.charAt(i) < '0') || (s.charAt(i) > '9'))
               throw new NumberFormatException(s + " is not a valid number");

           // build value one digit at a time
           else {
               // set the digit flag
               atLeastOne = true;

               // handle digits
               if (digitMode) {
                   iValue = (iValue * 10) + (s.charAt(i) - 48);
                   if (decimalCount == 1)
                       decimalDigits++;
               } // handle exponents
               else {
                   exponent = (exponent * 10) + (s.charAt(i) - 48);
               }
           }
       }

       // must be number
       if (!atLeastOne)
           throw new NumberFormatException(s + " is not a valid number");

       // adjust for exponent
       value = (double) iValue / Math.pow(10, decimalDigits);
       if (exponent != 0) {
           if (positiveExponent)
               for (int i = 0; i < exponent; ++i) {
                   value *= 10.0;
               }
           else
               for (int i = 0; i < exponent; ++i) {
                   value /= 10.0;
               }
       }

       // return value
       if (!positiveNumber) value *= -1.0;
       return value;
   }

}
