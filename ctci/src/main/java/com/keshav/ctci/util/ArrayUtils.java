package com.keshav.ctci.util;

public class ArrayUtils {

    public static void swap(int arr[], int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        if (max >= arr.length || min < 0 || min == max) {
            return;
        }
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
