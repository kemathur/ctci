package com.keshav.ctci.dp;


/*
*  Recursive multiply
*/

public class Q5 {


public static int multiply(int a, int b) {
    int smaller = (a > b ? b : a);
    int larger = (a > b ? a : b);
    
    return multiplyHelper(smaller, larger);
}


private static int multiplyHelper(int smaller, int larger) {
    if (smaller == 1) return larger;
    
    int a = smaller/2;
    int sum1 = multiplyHelper(a, larger);
    int sum2 = sum1;
    if(smaller %2 == 1) sum2= multiplyHelper(a+1, larger);

    return sum1 + sum2;
}


public static void main(String args[]) {
    System.out.println(multiply(8,4));
    System.out.println(multiply(1,8));
    System.out.println(multiply(5,5));
    System.out.println(multiply(8,7));
}


}
