package com.keshav.ctci.arrays;


/*
*  Chapter 01 Q5
*  Check if 1 string is 1 or more edits away.
*  eg: "pale", "bale"  -> true
*      "pale", "dala"  -> false
*/

public class Q5 {

    public static boolean edits(String a, String b) {
        if (Math.abs(a.length() -  b.length()) > 1) return false;

        char[] ar = a.toCharArray();
        char[] br = b.toCharArray();
        int la = a.length();
        int lb = b.length();
        int i=0;
        int j=0;
        boolean edit = false;

        while (i < la && j < lb) {
            if (ar[i] != br[j]) {
                if (edit) return false;
                else edit = true;

                //Delete if length a > b ar[i] : ar[i+1] = br[j]
                if (la > lb) {
                    i++;
                    continue;
                }
                //Insert if length a < length b ar[i] : ar[i+1] = br[j+1]
                else if(la < lb) {
                    j++;
                    continue;
                }
            }
            i++;
            j++;
        }
        return !((i != la || j != lb) && edit);
    }
    

    public static void main(String args[]) {
        System.out.println(edits("pale", "bale"));
        System.out.println(edits("pale", "ple"));
        System.out.println(edits("pale", "dala"));
        System.out.println(edits("pal", "pale"));
        System.out.println(edits("pale", "plle"));
    }
}
