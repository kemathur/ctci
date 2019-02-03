package com.keshav.ctci.linkedlist;


/*
  * Node for single linked list.
  * Has val and next.
*/
public class LLNode<T> {
    private T val;
    public LLNode<T> next;


    public LLNode(T val) {
        this.val = val;
    }

    public T val() {
        return val;
    }

}
