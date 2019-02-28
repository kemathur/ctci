package com.keshav.ctci.hash;

import com.keshav.ctci.list.ArrayList;
import com.keshav.ctci.list.LinkedList;
import com.keshav.ctci.util.KVPair;


public class HashMap<K, V> {

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

    @Override
    public String toString() {
        return "HashMap{" +
                "data=" + data +
                ", length=" + length +
                '}';
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
    }
}
