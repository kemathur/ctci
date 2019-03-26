package com.keshav.ctci.sorting;

import static com.keshav.ctci.util.ArrayUtils.swap;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int arr[]) {
        if (arr.length < 2) {
            return;
        }
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            if (k != i) {
                swap(arr, k, i);
            }
        }
    }

    public static void main(String args[]) {
        int[] a = {5,4,1,3,2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}


