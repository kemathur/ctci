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
        map.put(key, node);
        addToFront(node);
        size++;
    }

    private void addToFront(LLNode node) {
        node.next = head;
        head = node;
        if (head.next == null) {
            tail = head;
        }
    }

    public V get(K key) {
        if (map.get(key) == null) {
            return null;
        }

        LLNode<KVPair<K,V>> node = map.get(key);
        moveToFront(node);
        return node.val().value();
    }

    private void moveToFront(LLNode node) {
        if (head == node || head == null) {
            return;
        }

        // delete node
        LLNode p = head;
        while (p.next != null) {
            if(p.next == node) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }

        addToFront(node);
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
        Cache<String, Integer> cache = new Cache<>();
        cache.add("a", 1);
        cache.add("b", 2);
        cache.add("c", 3);
        cache.add("d", 4);

        System.out.println(cache.get("c"));
        System.out.println(cache);
    }
    
}
