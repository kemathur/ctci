package com.keshav.ctci.list;


public class StringBuilder {

    private char[] data;
    private int size;
    private static int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;

    public StringBuilder() {
        data = new char[capacity];
        size = 0;
    }


    public void append(String s) {
        if(s == null) return;
        checkSize(size+s.length());
        char[] arr= s.toCharArray();
        for (char anArr : arr) {
            data[size] = anArr;
            size++;
        }
    }

    private void checkSize(int toFill) {
        if (toFill>= capacity) {
            capacity *=2;
            if (toFill >= capacity) capacity += toFill;
            char[] newData = new char[capacity];
            for (int i=0; i< size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        return new String(data,0, size);
    }

    public static void main(String args[]) {
        StringBuilder builder = new StringBuilder();
        builder.append("a,");
        builder.append(" b,");
        builder.append(" c");
        System.out.println(builder.toString());
    }

}
