package com.keshav.ctci.list;


/*
  * Node for doubly linked list.
  * Has val, next and prev.
*/
public class DoubleLLNode<T> {
    private T val;
    public DoubleLLNode<T> next;
    public DoubleLLNode<T> prev;


    public DoubleLLNode(T val) {
        this.val = val;
    }

    public T val() {
        return val;
    }

    @Override
    public String toString() {
        return "LLNode{" +
                "val=" + val +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
