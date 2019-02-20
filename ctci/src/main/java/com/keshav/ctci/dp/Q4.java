package com.keshav.ctci.dp;

import java.util.ArrayList;
import java.util.List;

/*
*  CTCI Chapter 08 Q4
*  Return power set of a given set.
*/
public class Q4 {


    public static List<List<Integer>> powerSet(List<Integer> set) {
        List<List<Integer>> powerSet = new ArrayList<>();
        generatePowerSet(set, 0, powerSet);
        return powerSet;
    }

    private static void generatePowerSet(List<Integer> set, int index, List<List<Integer>> powerSet) {
        if (index == 0) {
            powerSet.add(new ArrayList<Integer>());
            generatePowerSet(set, index+1, powerSet);
            return;
        }
        if (index > set.size()) return;

        List<List<Integer>> newSets = new ArrayList<>();
        int element = set.get(index-1);
        for (List<Integer> s : powerSet) {
            List<Integer> newSet = new ArrayList<>();
            newSet.addAll(s);
            newSet.add(element);
            newSets.add(newSet);
        }
        powerSet.addAll(newSets);
        generatePowerSet(set, index+1, powerSet);
    }

    public static List<List<Integer>> powerSet2(List<Integer> set) {
        List<List<Integer>> powerSet = new ArrayList<>();
        int n = 1<<set.size();
        System.out.println("n: " + n);
        for (int i=0; i<n; i++) {
            powerSet.add(convertIntToSet(i, set));
        }
        return powerSet;
    }

    public static List<Integer> convertIntToSet(int k, List<Integer> set) {
        List<Integer> s = new ArrayList<>();
        int index = 0;
        for (int i=k; i>0; i>>=1) {
            if ((i & 1) == 1) s.add(set.get(index));
            index++;
        }
        return s;
    }

    public static void main(String args[]) {
        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println(powerSet(set));
        System.out.println(powerSet2(set));
        System.out.println(2<<3);
        System.out.println(16>>3);
        System.out.println(3 & 1);
    }
}
