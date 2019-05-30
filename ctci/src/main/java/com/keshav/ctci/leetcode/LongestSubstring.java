package com.keshav.ctci.leetcode;

class LongestSubstring {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        char []c = s.toCharArray();
        int n = c.length;
        if (n==0) return "";
        int a = -1;
        int b = -1;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j< n; j++) {
                int len = isPallindrome(c, i, j);
                if (len > 0 && len > max) {
                    max = len;
                    a = i;
                    b = j;
                }
            }
        }
        return new String(c, a, b);
    }

    private int isPallindrome(char[] c, int i, int j) {
        while(i >= j) {
            if (c[i] != c[j]) {
                return -1;
            }
        }
        return j-i;
    }
}