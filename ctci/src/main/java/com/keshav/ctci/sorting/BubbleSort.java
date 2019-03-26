package com.keshav.ctci.sorting;

import static com.keshav.ctci.util.ArrayUtils.swap;
import java.util.Arrays;

public class BubbleSort{


    // Sort in place
    public static void sort(int arr[]) {
        if (arr.length < 2) {
            return;
        }
        int n = arr.length;
        
        for (int i=0; i<n; i++) {
            boolean swapped = false;
            for (int j=n-1; j>i; j--) {
                if (arr[j]<arr[j-1]) {
                    swap(arr, j, j-1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }


    public static void main(String args[]) {
        int[] a = {5,4,1,3,2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
