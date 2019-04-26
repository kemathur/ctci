package com.keshav.ctci.leetcode;


import com.keshav.ctci.list.ArrayList;
import com.keshav.ctci.list.List;
import com.keshav.ctci.list.StringBuilder;

public class GenerateParanthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> stringList = new ArrayList<>();
        if (n < 2) return stringList;
        generateParenthesisHelper(0, 0, n, stringList, new StringBuilder());
        return stringList;
    }

    private static void generateParenthesisHelper(int i, int numOpen, int n, List<String> stringList, StringBuilder builder) {
        if (i== 0) {
            builder.append("(");
            generateParenthesisHelper(i+1, numOpen + 1, n, stringList, builder);
            return;
        }
        if(i == n) {
            if (numOpen == 0) stringList.add(builder.toString());
            return;
        }
        StringBuilder builder1 = builder.clone();
        builder1.append("(");
        generateParenthesisHelper(i+1, numOpen + 1, n, stringList, builder1);
        if (numOpen > 0) {
            builder.append(")");
            generateParenthesisHelper(i+1, numOpen - 1, n, stringList, builder);
        }
    }

    public static void main(String args[]) {
        System.out.println(generateParenthesis(5));
    }
}
