package com.keshav.ctci.dp;


import java.util.*;

public class Q7 {

    public static void permutations(char[] chars) {
        Set<Character> charSet = new HashSet<>();
        for(Character c: chars) {
            charSet.add(c);
        }
        permute("", charSet);
    }

    private static void permute(String prefix, Set<Character> chars) {
        if (chars.size() == 0) System.out.println(prefix);
        
        for (char c: chars) {
            Set<Character> chars2 = new HashSet<>();
            chars2.addAll(chars);
            chars2.remove(c);
            permute(prefix+c, chars2);
        }
    }

    
    public static void main(String args[]){
        permutations(new char[]{'a', 'b', 'c'});
    }

}
