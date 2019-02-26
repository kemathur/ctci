package com.keshav.ctci.list;


/*
*   Chapter 01
*
* */

public class Q4 {

    public Q4() {}

    public static LinkedList partition(LinkedList<Integer> list, int p) {
        LLNode<Integer> head;
        LLNode<Integer> tail;
        LLNode<Integer> pointer = list.head();
        head = new LLNode<>(pointer.val());
        tail = head;
        pointer = pointer.next;
        int size = 1;

        while(pointer != null) {
            LLNode<Integer> node = new LLNode<Integer>(pointer.val());
            if (pointer.val() < p){
                node.next = head;
                head = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
            pointer = pointer.next;
            size++;
        }
        return new LinkedList<Integer>(head, tail, size);
    }

    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(1);
        System.out.println(partition(list, 5));
    }

}
