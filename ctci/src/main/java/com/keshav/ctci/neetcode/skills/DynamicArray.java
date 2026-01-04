package com.keshav.ctci.neetcode.skills;

public class DynamicArray {

    private int[] arr;
    private int length;
    private int capacity;

    // Constructor to initialize the dynamic array
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[this.capacity];
    }

    // Get value at the i-th index
    public int get(int i) {
        return arr[i];
    }

    // Insert value n at the i-th index
    public void set(int i, int n) {
        arr[i] = n;
    }

    // Insert n in the last position of the array
    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    // Remove the last element in the array
    public int popback() {
        if (length > 0) {
            // soft delete the last element
            length--;
        }
        return arr[length];
    }

    // Resize the array
    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];
        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // Get the size of the array
    public int getSize() {
        return length;
    }

    // Get the capacity of the array
    public int getCapacity() {
        return capacity;
    }

    public static void main(String args[]) {
        DynamicArray a = new DynamicArray(1);
        System.out.println(a.getSize());
        System.out.println(a.getCapacity());        
    }
}
