package com.keshav.ctci.arrays;

/*
*  Chapter 01. Q1
*  String made up unique characters only. no repititions. 
*/
public class Q1 {

    public Q1() {}

    private static int intVal(char c) {
        return c - 'a';
    }

    public static boolean unique(String s) {
        if(s==null) return false;
        boolean[] arr = new boolean[s.length()];

        char[] cs = s.toCharArray();
        for (char c: cs) {
            int index = intVal(c);
            System.out.println(index);
            if (arr[index]) return false;
            arr[index] = true;
        }
        return true;
    }

    public static boolean unique2(String s) {
        if(s==null) return false;
        int filter = 0;

        char[] cs = s.toCharArray();
        for (char c: cs) {
            int index = intVal(c);
            int index2 = 1<<index;
            System.out.println(index);
            if ((filter & index2) > 0) return false;
            filter = (filter | index2);
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(unique("abcd"));
        System.out.println(unique("abccd"));
        System.out.println(unique2("abcd"));
        System.out.println(unique2("abccd"));
        System.out.println((int)'c');
    }

}
