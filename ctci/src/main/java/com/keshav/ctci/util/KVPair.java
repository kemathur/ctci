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

    public void setValue(V value) {
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "KVPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
