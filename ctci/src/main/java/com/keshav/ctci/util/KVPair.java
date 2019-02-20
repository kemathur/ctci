package com.keshav.ctci.util;


public class KVPair<K, V> {

    private K key;
    private V value;


    public KVPair(K k, V v) {
        key=k;
        value = v;
    }

    public K key() {
        return key;
    }

    public V value() {
        return value;
    }

    @Override
    public String toString() {
        return "KVPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
