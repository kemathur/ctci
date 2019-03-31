package com.keshav.ctci.list;


import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{

    private LLNode<T> head;
    private LLNode<T> tail;
    private int size;

    public LinkedList() {}

    public LinkedList(LLNode<T> head, LLNode<T> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public void add(T data) {
        if (data == null) return;
        if (tail==null) {
            head = new LLNode<T>(data);
            tail = head;
            return;
        }

        LLNode<T> d = new LLNode<T>(data);
        tail.next = d;
        tail = d;
    }

    public void remove(T data) {
        if (data == null || tail == null) return;
        if (data == head.val()) {
            head = head.next;
            if(head == null) tail = null;
            return;
        }

        LLNode p = head.next;
        while (p.next != null) {
            if (p.next == data) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
    }


    public T get(int index) {
        if(index >= size) return null;

        LLNode<T> pointer = head;
        int i=0;
        while(pointer!=null) {
            if(i==index)
                return pointer.val();
            pointer = pointer.next;
            i++;
        }
        return null;
    }

    public LLNode<T> head() {
        return head;
    }

    public LLNode<T> tail() {
        return tail;
    }

    public Object[] toArray() {
        if (size == 0) return null;
        Object[] arr = new Object[size];

        int i=0;
        LLNode<T> pointer = head;
        while(pointer!=null) {
            arr[i] = pointer.val();
            pointer = pointer.next;
            i++;
        }

        return arr;
    }

    public class LLIterator<X> implements Iterator<X> {

        LinkedList<X> parent;
        LLNode<X> pointer;

        public LLIterator(LinkedList<X> parent) {
            this.parent = parent;
            pointer = parent.head;
        }

        @Override
        public boolean hasNext() {
            return parent!= null && pointer != null;
        }

        @Override
        public X next() {
            LLNode<X> pointerOld = pointer;
            pointer = pointer.next;
            return pointerOld.val();
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new LLIterator<T>(this);
    }

    public int size() {
        return size;
    }
}
