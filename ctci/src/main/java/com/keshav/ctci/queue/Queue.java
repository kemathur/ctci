package com.keshav.ctci.queue;

import com.keshav.ctci.linkedlist.LLNode;

/*

insert(): back of queue
front():  return front node
dequeue(): return front node and remove that from top of queue

*/
public class Queue<T> {

    private LLNode<T> head;
    private LLNode<T> tail;
    private int size=0;

    
    public Queue() {}

    public void insert(T val) {
        LLNode<T> node = new LLNode<T>(val);
        if (tail != null) {
            tail.next = node;
            tail = node;
        }
        else {
            head = node;
            tail = node;
        }
        size++;
    }

    // Return head
    public T front() {
        if (head != null)
            return head.val();
        return null;
    }

    // Return head and delete
    public T deque() {
        T val = null;
        if (head != null) {
            val = head.val();
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        }
        return val;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

}
