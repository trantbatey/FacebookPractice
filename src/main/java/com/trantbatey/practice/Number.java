package com.trantbatey.practice;

public class Number {
    public static boolean isNumber(String s) {
        if (s==null) return false;
        int length = s.length();
        int indexStart = 0;
        while (s.charAt(indexStart) == ' ') {
            indexStart++;
            if (indexStart == length) return false;
        }
        if (s.charAt(indexStart) == '-') indexStart++;
        if (s.charAt(indexStart) == '+') indexStart++;
        if ((s.charAt(indexStart) == 'e') || (s.charAt(indexStart) == 'E')) return false;
        int dotCount = 0;
        int eCount = 0;
        
        // main loop
        boolean mustBeBlank = false;
        boolean atLeastOne = false;
        for (int i = indexStart; i < length; ++i) {
            if (mustBeBlank) {
                if (s.charAt(i) != ' ') return false;
            } else if (s.charAt(i) == '.') {
                dotCount++; 
                if (dotCount > 1) return false;
            } else if ((s.charAt(i) == 'e') || (s.charAt(i) == 'E')) {
                eCount++;
                dotCount++; // no decimals after e
                if ((i+1 < length) && (s.charAt(i+1) == '-' ||  s.charAt(i+1) == '+')) ++i;
                if (!atLeastOne) return false;
                atLeastOne = false;
                if (eCount > 1) return false;
            }
            else if (s.charAt(i) == ' ') mustBeBlank = true;
            else if ((s.charAt(i) < '0') || (s.charAt(i) > '9')) return false;
            else atLeastOne = true;
        }
        
        // must be number
        if (!atLeastOne) return false;
        return true;
    }

}
