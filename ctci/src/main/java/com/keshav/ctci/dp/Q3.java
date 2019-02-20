package com.keshav.ctci.dp;


public class Q3 {
    
    public static int magicNumber(int arr[]) {
        return getMagicNumber(arr, 0, arr.length-1);
    }

    private static int getMagicNumber(int arr[], int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start+end)/2;
//        System.out.println(mid);

        if (mid == arr[mid])
            return mid;
        else if (arr[mid] < mid)
            return getMagicNumber(arr, mid+1, end);
        else
             return getMagicNumber(arr, start, mid-1);
    }

    public static int magicNumber2(int arr[]) {
        return getMagicNumber2(arr, 0, arr.length-1);
    }

    private static int getMagicNumber2(int arr[], int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start+end)/2;
//        System.out.println(mid);

        int a = -1;
        int b = -1;
        if (mid == arr[mid])
            return mid;
        else if (arr[mid] < mid) {
            a = getMagicNumber2(arr, start, arr[mid]);
            b = getMagicNumber2(arr, mid+1, end);
        }
        else{
            a = getMagicNumber2(arr, arr[mid], end);
            b = getMagicNumber2(arr, start, mid-1);
        }

        return Math.max(a,b);
    }

    public static void main(String args[]) {
        int test1[] = {-11, -12, 1, 3, 11};
        int test2[] = {-11, 1, 1, 2, 11};
        System.out.println(magicNumber(test1));
        System.out.println(magicNumber2(test2));
    }

}
