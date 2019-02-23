package com.keshav.ctci.arrays;


import com.keshav.ctci.list.StringBuilder;

public class Q6{

    public static String compress(String s) {
        char[] sarr = s.toCharArray();
        StringBuilder buffer = new StringBuilder();
        char current = sarr[0];
        int count = 1;

        for (int i=1; i< s.length(); i++) {
            char c = sarr[i];
            if(c == current) count++;
            else {
                buffer.append("" + current+(count > 1 ? count : ""));
                current = c;
                count = 1;
            }
        }
        buffer.append("" + current+(count > 1 ? count : ""));

        return buffer.toString();
    }


    public static void main(String args[]) {
        System.out.println(compress("aabbccd"));
        System.out.println(compress("abcdee"));
    }

}
