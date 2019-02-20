package com.keshav.ctci.dp;


public class Fibonacci {
    public Fibonacci() {
    }


    public static int fib(int i) {
        if (i==0) return 0;
        if (i==1) return 1;

        return fib(i-1) + fib(i-2);
    }


    public static int fib2(int i, int fib[]) {
        if (i==0) fib[0]=0;
        if (i==1) fib[1]=1;

        if (fib[i] > 0 || i==0) return fib[i];
        fib[i] = fib2(i-1, fib) + fib2(i-2, fib);

        return fib[i];
    }

    public static int fib3(int i) {
        if (i==0) return 0;
        if (i==1) return 1;


        int fib[] = new int[i+1];
        fib[0] = 0;
        fib[1] = 1;

        for (int j=2; j<= i; j++) {
            fib[j] = fib[j-1] + fib[j-2];
        }

        return fib[i];
    }

    public static int fib4(int i) {
        if (i==0) return 0;
        if (i==1) return 1;


        int a = 0;
        int b = 1;
        int c = 0;
        for (int j=2; j<=i; j++) {
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String args[]) {
        System.out.println(fib(0));
        System.out.println(fib2(0, new int[1]));
        System.out.println(fib3(0));
        System.out.println(fib4(0));
        System.out.println(fib(1));
        System.out.println(fib2(1, new int[2]));
        System.out.println(fib3(1)); 
        System.out.println(fib4(1));
        System.out.println(fib(5));
        System.out.println(fib2(5, new int[6]));
        System.out.println(fib3(5));
        System.out.println(fib4(5));
        System.out.println(fib(8));
        System.out.println(fib2(8, new int[9]));
        System.out.println(fib3(8));
        System.out.println(fib4(8));
    }



}
