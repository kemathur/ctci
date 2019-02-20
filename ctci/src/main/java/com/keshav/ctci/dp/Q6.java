package com.keshav.ctci.dp;


/*
*  tower of hanoi
*  move from 1 to 3
*/

public class Q6{

    public static void toh(int n) {
        tower(n, 1, 3, 2);
        System.out.println("========================");
    }

    private static void tower(int n, int source, int des, int buffer) {
        if (n == 0) return;
        tower(n-1, source, buffer, des);
        System.out.println("Move " + n + " from " + source + " to " + des);
        tower(n-1, buffer, des, source);
    }

    public static void main(String args[]) {
        toh(1);
        toh(2);
        toh(3);
        toh(4);
        //        System.out.println(toh(1));
//        System.out.println(toh(2));
        // System.out.println(toh(3));
        // System.out.println(toh(4));
    }

}
