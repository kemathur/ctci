package com.keshav.ctci.trees;


import java.util.Arrays;

/*
*  Complete Binary tree where root is the minimum.
*  Thus can be represented by an array.
*  root       = v[0]
*  left(i)    = v[2i + 1]
*  right(i)   = v[2i + 2]
*  parent(i)  = v[(i-1)/2]      Probably this is a floor.
*/
public class BinaryHeap{
    private double v[];
    private static int DEFAULT_SIZE = 20;
    private int filled =0;

    public BinaryHeap() {
        this(DEFAULT_SIZE);
    }

    public  BinaryHeap(int size) {
        v = new double[size];
    }

    private void swap(int x, int y){
        double temp = v[x];
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
            if (v[p] > v[i]){
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
    public double getMin(){
        if (filled > 0)
            return v[0];
        else
            return Double.NEGATIVE_INFINITY;
    }

    // start from root. And bubble down till heap property satisfied.
    private void bubbleDown() {
        int i = 0;
        int lc = left(i);
        int rc = right(i);
        while (lc < filled || rc < filled){
            if(lc < filled && v[lc] < v[i]) {
                swap(i, lc);
                i = lc;
            }
            else if(rc < filled && v[rc] < v[i]) {
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
    public double extractMin(){
        if (filled == 0)
            return Double.NEGATIVE_INFINITY;
        double root = v[0];
        v[0] = v[filled-1];
        filled--;
        bubbleDown();
        return root;
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
