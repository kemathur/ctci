package com.keshav.ctci.hash;

import com.keshav.ctci.list.ArrayList;
import com.keshav.ctci.list.LinkedList;
import com.keshav.ctci.util.KVPair;


import java.util.Iterator;


public class HashMap<K, V> implements Iterable<KVPair<K, V>>{

    private ArrayList<LinkedList<KVPair<K,V>>> data;
    private int length;
    int size;
    private static int DEFAULT_LENGTH = 100;

    public HashMap() {
        this(DEFAULT_LENGTH);
    }

    public HashMap(int length) {
        this.length = length;
        this.size = 0;
        data = new ArrayList<>();
        for(int i=0; i<length; i++) {
            data.add(new LinkedList<KVPair<K,V>>());
        }
    }

    public void put(K key, V value) {
        int index = key.hashCode()%length;
        KVPair<K,V> pair = new KVPair<K,V>(key, value);
        LinkedList<KVPair<K,V>> list = data.get(index);
        // check if key already present
        for (KVPair<K,V> kv : list) {
            if (kv.key() == key){
                kv.setValue(value);
                size++;
                return;
            }
        }
        data.get(index).add(pair);
        size++;
    }

    public V get(K key) {
        int index = key.hashCode()%length;
        KVPair pair;
        LinkedList<KVPair<K,V>> list = data.get(index);
        for (KVPair<K, V> p : list) {
            if (p.key() == key)
                return p.value();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void remove(K key) {
        int index = key.hashCode()%length;
        LinkedList<KVPair<K,V>> list = data.get(index);
        for (KVPair<K, V> p : list) {
            if (p.key() == key){
                list.remove(p);
                size--;
            }
        }
    }

    public boolean isKeyPresent(K key){
        if(key == null) return false;
        int index = key.hashCode()%length;
        LinkedList<KVPair<K,V>> list = data.get(index);
        for (KVPair<K, V> p : list) {
            if (p.key() == key)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "data=" + data +
                ", length=" + length +
                '}';
    }

    @Override
    public Iterator<KVPair<K, V>> iterator() {
        return new HashMapIterator(this);
    }

    public class HashMapIterator implements Iterator<KVPair<K, V>> {
        private HashMap<K, V> parent;
        private int index;
        private Iterator<KVPair<K, V>> llIterator;

        private HashMapIterator(HashMap<K, V> parent) {
            this.parent = parent;
            index = 0;
            llIterator = getLLIterator(0);
        }

        private Iterator<KVPair<K, V>> getLLIterator(int index) {
            if (parent.data.get(index) != null) {
                return parent.data.get(index).iterator();
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return hasNext(index, llIterator);
        }

        private boolean hasNext(int index, Iterator<KVPair<K, V>> listIter) {
            boolean val = (index < parent.length &&
                    ((listIter != null && listIter.hasNext())
                            || hasNext(index+1, getLLIterator(index+1))));
            return val;
        }

        @Override
        public KVPair<K, V> next() {
            KVPair<K, V> elem = null;
            if(index < parent.length) {
                if(llIterator != null && llIterator.hasNext()) {
                    elem = llIterator.next();
                }
                else {
                    index++;
                    llIterator = getLLIterator(index);
                    return next();
                }
            }
            return elem;
        }
    }

    public static void main(String args[]){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        System.out.println(map);
        System.out.println(map.get("b"));
        System.out.println(map.size());
        for (KVPair<String, Integer> kv : map) {
            System.out.println("(" + kv.key() + ", " + kv.value() + ")");
        }
        System.out.println("======================");
        map.remove("b");
        System.out.println(map.size());
        for (KVPair<String, Integer> kv : map) {
            System.out.println("(" + kv.key() + ", " + kv.value() + ")");
        }
    }
}
