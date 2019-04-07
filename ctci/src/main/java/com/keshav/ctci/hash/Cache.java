package com.keshav.ctci.hash;


import com.keshav.ctci.list.LLNode;
import com.keshav.ctci.list.LinkedList;
import com.keshav.ctci.util.KVPair;

/*
*  Cache implementation
*  Hashmap proivdes efficient lookups
*  LinkedList provides order of freshness. Deletes stale data after a certain size is hit.
*  Semantics: head contains latest data, tail: oldest
*  Size: size of the cache (max elements that it supports)
*  TODO: need to keep fixed size and delete stale elements
* */

public class Cache<K,V> {
    private HashMap<K,LLNode<KVPair<K,V>>> map;
    private LLNode<KVPair<K,V>> head;
    private LLNode<KVPair<K,V>> tail;
    public static int DEFAULT_SIZE = 100;
    private int size;

    public Cache() {
        this(DEFAULT_SIZE);
    }

    public Cache(int n) {
        if (n < 0) n = DEFAULT_SIZE;
        size = n;
        map = new HashMap<>();
    }

    public void add(K key, V value) {
        // update result
        if (map.get(key) != null) {
            LLNode<KVPair<K,V>> node = map.get(key);
            node.val().setValue(value);
            moveToFront(node);
            return;
        }
        // add new
        LLNode<KVPair<K, V>> node = new LLNode<>(new KVPair<K, V>(key, value));
        // delete stale data
        if (size == map.size()) {
            deleteOldData();
        }
        map.put(key, node);
        addToFront(node);
    }

    private void deleteOldData() {
        if (head != null) {
            map.remove(head.val().key());
            head = head.next;
        }
    }

    public V get(K key) {
        if (map.get(key) == null) {
            return null;
        }

        LLNode<KVPair<K,V>> node = map.get(key);
        V val = node.val().value();
        moveToFront(node);
        return val;
    }

    // Add to tail
    private void addToFront(LLNode node) {
        if (tail == null) {
            tail = node;
            head = tail;
            return;
        }
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    private void moveToFront(LLNode node) {
        if (head == node || head == null) {
            return;
        }

        // delete node
        if(node.next != null) {
            LLNode temp = node.next;
            if (tail == temp)
                tail = node;
            KVPair swap = (KVPair) node.val();
            node.setVal(temp.val());
            node.next = temp.next;
            temp.setVal(swap);
            addToFront(temp);
        }
    }

    @Override
    public String toString() {
        return "Cache{" +
                "map=" + map + "\n" +
                ", head=" + head + "\n" +
                ", tail=" + tail + "\n" +
                ", size=" + size + "\n" +
                '}';
    }

    public static void main(String args[]) {
        Cache<String, Integer> cache = new Cache<>(4);
        cache.add("a", 1);
        cache.add("b", 2);
        cache.add("c", 3);
        cache.add("d", 4);

        System.out.println(cache.get("c"));
        System.out.println(cache);
        cache.add("e", 5);
        System.out.println(cache.get("a"));
        System.out.println(cache);
    }
    
}
