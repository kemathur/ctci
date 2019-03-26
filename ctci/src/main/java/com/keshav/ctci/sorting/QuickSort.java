package com.keshav.ctci.sorting;

import static com.keshav.ctci.util.ArrayUtils.swap;

import java.util.Arrays;

/*
    * Lamuto partition scheme:
    * pivot is last element
*/
public class QuickSort {
    public static void sort(int arr[]) {
        if (arr.length < 2) {
            return;
        }
        int n = arr.length;

        sort(arr, 0, n-1);
    }

    private static void sort(int arr[], int low, int high) {
        if (low >= high || low < 0) return;
        int p = partition(arr, low, high);

        sort(arr, low, p-1);
        sort(arr, p+1, high);
    }

    // partiotion array around the pivot
    // pivot srategy: last element
    private static int partition(int arr[], int low, int high) {
        int p = low;
        int pp = low;
        int pivot = arr[high];

        for (; p<=high; p++) {
            if (arr[p] < pivot) {
                if (p > pp)
                    swap(arr, p, pp);
                pp++;
            }
        }

        // swap pivot with pp
        swap(arr, high, pp);
        return pp;
    }

    public static void main(String args[]) {
        int[] a = {5,4,1,3,2};
        sort(a);
        System.out.println(Arrays.toString(a));
        int[] b = {5,4,1,3,2, 11,  7, 0};
        sort(b);
        System.out.println(Arrays.toString(b));
    }

}


