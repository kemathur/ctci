package com.keshav.ctci.list;


import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T>{

    private DoubleLLNode<T> head;
    private DoubleLLNode<T> tail;
    private int size;

    public DoubleLinkedList() {}

    public void add(T data) {
        if (data == null) return;
        if (tail==null) {
            head = new DoubleLLNode<T>(data);
            tail = head;
            return;
        }

        DoubleLLNode<T> d = new DoubleLLNode<T>(data);
        tail.next = d;
        d.prev = tail;
        tail = d;
    }


    public T get(int index) {
        if(index >= size) return null;

        DoubleLLNode<T> pointer = head;
        int i=0;
        while(pointer!=null) {
            if(i==index)
                return pointer.val();
            pointer = pointer.next;
            i++;
        }
        return null;
    }


    public Object[] toArray() {
        if (size == 0) return null;
        Object[] arr = new Object[size];

        int i=0;
        DoubleLLNode<T> pointer = head;
        while(pointer!=null) {
            arr[i] = pointer.val();
            pointer = pointer.next;
            i++;
        }

        return arr;
    }

    public class LLIterator<X> implements Iterator<X> {

        DoubleLinkedList<X> parent;
        DoubleLLNode<X> pointer;

        public LLIterator(DoubleLinkedList<X> parent) {
            this.parent = parent;
            pointer = parent.head;
        }

        @Override
        public boolean hasNext() {
            return parent!= null && pointer != null;
        }

        @Override
        public X next() {
            DoubleLLNode<X> pointerOld = pointer;
            pointer = pointer.next;
            return pointerOld.val();
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new LLIterator<T>(this);
    }
}
