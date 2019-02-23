package com.keshav.ctci.arrays;

/*
*  Chap 01 Q3
*  URLify: replace spaces inplace with %20
*  I/P : "a b c    ", 5
*  O/P : "a%20b%20c"
*/
public class Q3 {

    public static char[] urlify(char s[], int l) {
        if (s==null) return null;

        int n = s.length;
        int i = n-l;
        int j = n-1;

        while(i != j) {
            if (s[i] != ' ') {
                s[j] = s[i];
                i--;
                j--;
            }
            else {
                s[j--] = '0';
                s[j--] = '2';
                s[j--] = '%';
                i--;
            }
        }

        return s;
    }


    public static void main(String args[]) {
        System.out.println(urlify("a b c    ".toCharArray(), 5));
    }
}
