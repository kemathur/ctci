package com.keshav.ctci.hash;

import com.keshav.ctci.list.ArrayList;
import com.keshav.ctci.list.LLNode;
import com.keshav.ctci.list.LinkedList;
import com.keshav.ctci.util.KVPair;


public class HashSet<K> {

    private ArrayList<LinkedList<K>> data;
    private int length;
    int size;
    private static int DEFAULT_LENGTH = 100;

    public HashSet() {
        this(DEFAULT_LENGTH);
    }

    public HashSet(int length) {
        this.length = length;
        this.size = 0;
        data = new ArrayList<>();
        for(int i=0; i<length; i++) {
            data.add(new LinkedList<K>());
        }
    }

    public boolean isPresent(K key) {
        int index = key.hashCode()%length;
        LinkedList<K> list = data.get(index);
        for(K k: list) {
            if(k == key) return true;
        }
        return false;
    }

    public void add(K key) {
        if (!isPresent(key)){
            int index = key.hashCode()%length;
            data.get(index).add(key);
            size++;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "HashSet{" +
                "data=" + data +
                ", length=" + length +
                '}';
    }


    public static void main(String args[]){
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("d");
        System.out.println(set);
        System.out.println(set.isPresent("b"));
        System.out.println(set.size());
    }
}
