package com.keshav.ctci.hash;

import com.keshav.ctci.list.ArrayList;
import com.keshav.ctci.list.LLNode;
import com.keshav.ctci.list.LinkedList;
import com.keshav.ctci.util.KVPair;

import java.util.Iterator;


public class HashSet<K> implements Set<K>, Iterable<K>{

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

    @Override
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

    @Override
    public Iterator<K> iterator() {
        return new HashSetIterator<K>(this);
    }

    public class HashSetIterator<T> implements Iterator<T> {
        private HashSet<T> parent;
        Iterator<T> listIter;
        int index;

        public HashSetIterator(HashSet<T> parent) {
            this.parent = parent;
            this.index = 0;
            this.listIter = (parent.data.get(0) != null ? parent.data.get(0).iterator() : null);
        }

        @Override
        public boolean hasNext() {
            return hasNext(index, listIter);
        }

        private boolean hasNext(int index, Iterator<T> listIter) {
            boolean val = (index < parent.length &&
                                ((listIter != null && listIter.hasNext())
                                        || hasNext(index+1,
                                            (parent.data.get(index) != null
                                                ? parent.data.get(index).iterator() : null))));
            return val;
        }

        @Override
        public T next() {
            T elem = null;
            if(index < parent.length) {
                if(listIter != null && listIter.hasNext()) {
                    elem = listIter.next();
                }
                else {
                    index++;
                    listIter = (parent.data.get(index) != null ? parent.data.get(index).iterator() : null);
                    return next();
                }
            }
            return elem;
        }
    }

    public static void main(String args[]){
        HashSet<String> set = new HashSet<>(10);
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("d");
        System.out.println(set);
        System.out.println(set.isPresent("b"));
        System.out.println(set.size());
        for (String v : set) {
            System.out.println("priniting : " + v);
        }
    }
}
