package com.trantbatey.practice;

public class RegEx {
    public static boolean isMatch(String s, String p) {
        int i = s.length() - 1;
        int j = p.length() - 1;
        
        while (i > -1) {
            if (j < 0) return false;
            if (s.charAt(i) == p.charAt(j)) {
                i--;
                j--;
            } else if (p.charAt(j) == '.') {
                i--;
                j--;
            } else if (p.charAt(j) == '*') {
                if (j == 0) return false;
                j--;
                
                if (p.charAt(j) == '.') {
                    // any number of any chars including no chars                	
                    if (j == 0) return true;
                    j--;
                    String pSub = p.substring(0,j+1);
                    while (i > -1) {
                        String sSub = s.substring(0,i+1);
                        if (isMatch(sSub, pSub)) return true;
                        i--;
                    }
                    
                } else {
                	// any number of matching chars including no matching chars
                    char matcher = p.charAt(j);
                    j--;
                    String pSub = p.substring(0,j+1);
                    int k = i;
                    while ((k > -1) && (s.charAt(k) == matcher)) {
                        String sSub = s.substring(0,k+1);
                        if (isMatch(sSub, pSub)) return true;
                    	k--;
                    }
                    String sSub = s.substring(0,k+1);
                    if (isMatch(sSub, pSub)) return true;
                }
            } else {
            	return false;
            }
        }
        while (j > -1) {
            if (p.charAt(j) == '*' && j > 0) j -= 2;
            else return false;
        }
        return true;
        
    }

}
