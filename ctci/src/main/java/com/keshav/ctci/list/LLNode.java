package com.keshav.ctci.list;


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

    @Override
    public String toString() {
        return "LLNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public LLNode<T> clone() {
        LLNode<T> clone = new LLNode<>(val);
        clone.next = next;
        return clone;
    }

    public void setVal(T val) {
        this.val = val;
    }
}
