package com.keshav.ctci.hash;
import com.keshav.ctci.hash.HashMap;
import com.keshav.ctci.list.LinkedList;
import com.keshav.ctci.util.KVPair;

/*
*  Its an ordered Dictionary.
*  Helps return the keys with order.
*  Basically store the data in a Hashmap and a linkedlist
*/
public class LinkedHashMap<K, V>{

    private HashMap<K,V> map;
    private LinkedList<KVPair<K, V>> list;

    public LinkedHashMap() {}

    public void put(K key, V value) {
        map.put(key, value);
        if (!map.isKeyPresent(key))
            list.add(new KVPair<K, V>(key, value));
    }

    public V get(K key) {
        return map.get(key);
    }


}
