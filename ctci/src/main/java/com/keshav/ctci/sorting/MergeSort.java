package com.keshav.ctci.sorting;

import static com.keshav.ctci.util.ArrayUtils.swap;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int arr[]) {
        if (arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int arr[], int low, int high) {
        if (low >= high) return;
        int mid = (low+high)/2;
        sort(arr, low, mid);
        sort(arr, mid+1, high);

        merge(arr, low, mid, high);
    }

    // merge two sorted sides of an array.
    // left pointer and right pointer.
    private static void merge(int arr[], int low, int mid, int high) {
        int b[] = new int[high - low + 1];
        int lp = low;
        int rp = mid+1;
        int p=0;
        
        while (lp <= mid && rp <= high) {
            if (arr[lp] < arr[rp]) {
                b[p++] = arr[lp++];
            }
            else {
                b[p++] = arr[rp++];
            }
        }

        while (lp <= mid) {
            b[p++] = arr[lp++];
        }

        while (rp <= high) {
            b[p++] = arr[rp++];
        }

        // add elements to a
        for (p=low; p<=high; p++) {
            arr[p] = b[p - low];
        }
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


