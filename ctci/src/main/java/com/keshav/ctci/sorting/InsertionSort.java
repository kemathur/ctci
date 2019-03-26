package com.keshav.ctci.sorting;

import static com.keshav.ctci.util.ArrayUtils.swap;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int arr[]) {
        if (arr.length < 2) {
            return;
        }
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1 && arr[j] < arr[j-1]; j--)
                swap(arr, j, j-1);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String args[]) {
        int[] a = {5,4,1,3,2};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}