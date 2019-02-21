package com.keshav.ctci.list;


import java.util.Arrays;

public class ArrayList<T> {

    private Object data[];
    public static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity = DEFAULT_CAPACITY;


    public ArrayList() {
        data = new Object[capacity];
        size = 0;
    }

    public void add(T e) {
        checkSize();
        data[size++] = e;
    }

    public T get(int index) {
        return checkIndex(index) ? (T) data[index] : null;
    }

    public void set(int index, T d) {
        if(checkIndex(index)) data[index] = d;
    }

    private boolean checkIndex(int index) {
        return !(index >= size);
    }

    private void checkSize() {
        if (size >= capacity) {
            capacity *=2;
            Object[] newData = new Object[capacity];
            for (int i=0; i< size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "data=" + Arrays.toString(Arrays.copyOf(data, size)) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i< 50; i++)
            list.add(i);

        System.out.println(list.size());
        System.out.println(list.get(3));
        list.set(3, 5);
        System.out.println(list.get(3));
        System.out.println(list);
    }

}
