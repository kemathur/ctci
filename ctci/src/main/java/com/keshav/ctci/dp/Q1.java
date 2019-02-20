package com.keshav.ctci.dp;

/*
*  CTCI Chapter 08 Q1
* */
public class Q1{
    
    public static int numStep(int n) {
        return getNumStep(n, 1, new int[n]);
    }

    public static int getNumStep(int n, int start, int arr[]) {
        if (start == n) return 1;
        if (start > n) return 0;

        if (arr[start-1] > 0) return arr[start-1];

        arr[start-1] = getNumStep(n, start+1, arr) + getNumStep(n, start+2, arr)
                        + getNumStep(n, start+3, arr);
        return arr[start-1];    
    }


    public static void main(String args[]) {
        System.out.println(numStep(0));   
        System.out.println(numStep(1));
        System.out.println(numStep(2));   
        System.out.println(numStep(3));   
        System.out.println(numStep(4));   
        System.out.println(numStep(5));   
    }

}
