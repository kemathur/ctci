package com.keshav.ctci.queue;

import com.keshav.ctci.list.LLNode;

/*
Stack implemented using a linkedlist
push(): top of stack
pop() : delete top of statck and return
peek():  return top node

*/
public class Stack<T> {

    private LLNode<T> head;
    private int size=0;


    public Stack() {}

    // Push to top of stack
    public void push(T val) {
        LLNode<T> node = new LLNode<T>(val);
        if (head != null) {
            head = node;
        }
        node.next = head;
        head = node;
        size++;
    }

    // Return head
    public T peek() {
        return (head != null ? head.val() : null);
    }

    // Return head and delete
    public T pop() {
        T val = null;
        if (head != null) {
            val = head.val();
            head = head.next;
            size--;
        }
        return val;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

}
