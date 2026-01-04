package com.keshav.ctci.neetcode.skills;

import java.util.ArrayList;

public class LinkedList {

    class Node {
        int val;
        Node next;

        Node (int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;

    public LinkedList() {
        
    }

    public int get(int index) {
        if (head == null) return -1;

        Node p = head;
        int i = 0;

        while (p != null) {
            if (i == index) return p.val;
            p = p.next;
            i++;
        }

        return -1;
    }

    public void insertHead(int val) {
        Node t = new Node(val);
        if (head != null) {
            t.next = head;
        }
        head = t;
        if (tail == null) tail = head;
    }

    public void insertTail(int val) {
        Node t = new Node(val);
        if (tail != null) {
            tail.next = t;
        }
        tail = t;
        if (head == null) head = t;
    }

    public boolean remove(int index) {
        if (head == null) return false;
        if (index == 0) {
            if (tail == head) tail = null;
            head = head.next;
            return true;
        }
        
        int i = 0;
        Node p = head;
        while (p.next != null) {
            if (index == i+1) {
                p.next = p.next.next;
                if (p.next == null) tail = p;
                return true;
            }
            p = p.next;
            i++;
        }
        
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> l = new ArrayList<>();
        Node p = head;

        while (p != null) {
            l.add(p.val);
            p = p.next;
        }

        return l;
    }

    public static void main(String args[]) {
        LinkedList l = new LinkedList();
        System.out.println(l.get(0));
        l.insertHead(1);
        l.insertTail(2);
        System.out.println(l.getValues());
        l.insertTail(3);
        l.insertHead(0);
        System.out.println(l.get(2));
        System.out.println(l.getValues());
        l.remove(2);
        System.out.println(l.getValues());
        System.out.println(l.get(2));
    }
}
