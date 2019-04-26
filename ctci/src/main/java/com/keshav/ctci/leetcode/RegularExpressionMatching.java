package com.keshav.ctci.leetcode;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        boolean match = false;
        if (s == null || p == null) return false;
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        int n = str.length;
        int m = pattern.length;
        if (n == 0 || m == 0) return false;
        int i = 0;
        int j = 0;

        return match(str, pattern, i, j, n, m);
    }

    boolean match(char[] str, char[] pattern, int i, int j, int n, int m) {
        if (j==m) return i == n;
        if (i < 0 || j < 0) return false;
        boolean firstMatch = str[i] == pattern[j] || pattern[j] == '.';

        if (j < m-1 && pattern[j+1] == '*') {
            return match(str, pattern, i, j+2, n, m) ||
                    firstMatch && match(str, pattern, i+1, j, n, m);
        }
        else {
            return firstMatch && match(str, pattern, i+1, j+1, n, m);
        }
    }

    public static void main(String args[]) {

    }
}
