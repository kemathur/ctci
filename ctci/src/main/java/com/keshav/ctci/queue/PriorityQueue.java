package com.keshav.ctci.queue;

import com.keshav.ctci.trees.BinaryHeap;

import java.util.Arrays;

public class PriorityQueue<T extends Comparable<T>>{

    private Object v[];
    private static int DEFAULT_SIZE = 20;
    private int filled =0;

    public PriorityQueue() {
        this(DEFAULT_SIZE);
    }

    public  PriorityQueue(int size) {
        v = new Object[size];
    }

    private void swap(int x, int y){
        Object temp = v[x];
        v[x] = v[y];
        v[y] = temp;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int left(int i) {
        return 2*i + 1;
    }

    private int right(int i) {
        return 2*i + 2;
    }

    private void reSort() {
        int i = filled;
        int p = parent(filled);
        while(p >= 0) {
            if (((T) v[p]).compareTo(((T) v[i])) > 0){
                swap(p,i);
                i = p;
                p = parent(i);
            }
            else{
                return;
            }
        }
    }

    /*
     *  O(logn)
     *  Insert at end of tree.
     *  Then bubble up to find where it fits the min property.
     */
    public void insert(double x) {
        v[filled] = x;
        reSort();
        filled++;
    }


    /*
     *  O(1)
     *  return root.
     */
    public T getMin(){
        if (filled > 0)
            return (T) v[0];
        else
            return null;
    }

    // start from root. And bubble down till heap property satisfied.
    private void bubbleDown() {
        int i = 0;
        int lc = left(i);
        int rc = right(i);
        while (lc < filled || rc < filled){
            if(lc < filled && ((T) v[lc]).compareTo((T) v[i]) < 0) {
                swap(i, lc);
                i = lc;
            }
            else if(rc < filled && ((T) v[rc]).compareTo((T) v[i]) < 0) {
                swap(i, rc);
                i = rc;
            }
            lc = left(i);
            rc = right(i);
        }
    }

    /*
     *  O(logn)
     *  Replace root with last element.
     *  Bubble down.
     */
    public T extractMin(){
        if (filled == 0)
            return null;
        Object root = v[0];
        v[0] = v[filled-1];
        filled--;
        bubbleDown();
        return (T) root;
    }

    @Override
    public String toString() {
        return "BinaryHeap{" +
                "v=" + Arrays.toString(v) +
                ", filled=" + filled +
                '}';
    }

    public static void main(String args[]) {
        BinaryHeap heap = new BinaryHeap();
        heap.insert(10);
        heap.insert(13);
        heap.insert(15);
        heap.insert(40);
        heap.insert(20);
        heap.insert(17);
        heap.insert(31);
        System.out.println(heap);
        System.out.println("Min: " + heap.getMin());
        heap.insert(4);
        System.out.println("Min: " + heap.getMin());
        System.out.println(heap);
        double min = heap.extractMin();
        System.out.println("Min: " + min);
        System.out.println(heap);
    }
}
