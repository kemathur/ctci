package com.keshav.ctci.leetcode;

import com.keshav.ctci.queue.Stack;

/*
* https://leetcode.com/problems/basic-calculator/discuss/62361/Iterative-Java-solution-with-stack
* Simple iterative solution by identifying characters one by one. One important thing is that the input is valid,
 * which means the parentheses are always paired and in order.
Only 5 possible input we need to pay attention:

digit: it should be one digit from the current number
'+': number is over, we can add the previous number and start a new number
'-': same as above
'(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within
 the parenthesis.
')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis,
 second is the temporary result before this pair of parenthesis. We add them together.
Finally if there is only one number, from the above solution, we haven't add the number to the result,
 so we do a check see if the number is zero.

*
* */

public class EvaluateExpression {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }

//    // expecting a number
//    public static void push(char c, LinkedList<Character> stack) {
//        if (stack.isEmpty() || stack.peekFirst() == '(') {
//            System.out.println("push " + c);
//            stack.push(c);
//            return;
//        }
//        char symbol = stack.pop();
//        System.out.println("symbol " + symbol);
//        int val1 = Character.getNumericValue(c);
//        System.out.println("val1 " + val1);
//        int val2 = Character.getNumericValue(stack.poll());
//        System.out.println("val2 " + val2);
//        int res = (symbol == '+' ? val2 + val1 : val2 - val1);
//        push((char)(Integer.toString(res).charAt(0)), stack);
//    }

    public static void main(String args[]) {
        System.out.println( (int) '2' - (int)'0');
        System.out.println(calculate("1+2"));
        System.out.println(calculate("1+2+3"));
        System.out.println(calculate("1+(2+3)"));
        System.out.println(calculate("(1+2)+3"));
        System.out.println(calculate("(1+2)-3"));
        System.out.println(calculate("(1+2)-(3+0)"));
        System.out.println(calculate("(1+2)-(3+2)"));
    }

}
