package com.keshav.ctci.queue;

import com.keshav.ctci.list.LLNode;

/*
CTCK Chap 02 Q1
Stack implementataion with keeping min.
push()  :  top of stack
pop()   :  delete top of statck and return
peek()  :  return top node
min()   :  return min of stack
*/
public class MinStack<T extends Integer> {

    private LLNode<T> head;
    private LLNode<T> minHead;
    private int size=0;

    public MinStack() {}

    // Push to top of stack
    public void push(T val) {
        LLNode<T> node = new LLNode<T>(val);
        T minVal;
        if (head != null)
            minVal = min(val, minHead.val());
        else
            minVal = val;
        LLNode<T> minNode = new LLNode<T>(minVal);
        // update min and stack
        node.next = head;
        head = node;
        minNode.next = minHead;
        minHead = minNode;
        size++;
    }

    private T min(T a, T b){
        return (a.intValue() > b.intValue() ? b : a);
    }

    // Return head
    public T peek() {
        return (head != null ? head.val() : null);
    }

    // Return min
    public T min() {
        return (minHead != null ? minHead.val() : null);
    }


    // Return head and delete. Also update min stack.
    public T pop() {
        T val = null;
        if (head != null) {
            val = head.val();
            head = head.next;
            minHead = minHead.next;
            size--;
        }
        return val;
    }

    public boolean isEmpty() {
        return (size == 0);
    }


    public void push(T a[]) {
        if (a==null) return;
        for (int i=0; i< a.length; i++) {
            push(a[i]);
        }
    }


    public int size() {
        return size;
    }

    private LLNode<T> getMinHead() {
        return minHead;
    }

    public static void main(String args[]) {
        MinStack<Integer> stack = new MinStack<Integer>();
        Integer[] a = {1,2,3,4,5,6,-1,3,11,-10};
        stack.push(a);
        System.out.println(stack.getMinHead());
        System.out.println(stack.size());
    }


}
