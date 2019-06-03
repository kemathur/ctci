package com.keshav.ctci.trees;


import com.keshav.ctci.hash.HashMap;

public class Trie<T> {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(' ');
    }

    public class TrieNode {
        char c;
        T val;
        HashMap<Character, TrieNode> childMap;

        public TrieNode(char c) {
            this.c = c;
            childMap = new HashMap<>();
        }

        private void insert(char x) {
            if (childMap.get(x) != null) return;
            childMap.put(x, new TrieNode(x)); 
        }

        public void put(String s, T val) {
            if (s.equals("")) return;
            char x = s.charAt(0);
            insert(x);
            if (s.length() > 1)
                childMap.get(x).put(s.substring(1), val);
            else
                childMap.get(x).val = val;
        }

        public T get(String s) {
            if (s.equals("")) return null;
            char x = s.charAt(0);
            if (childMap.get(x) != null) {
                return (s.length() > 1 ? childMap.get(x).get(s.substring(1)) : childMap.get(x).val);
            }
            return null;
        }
    }

    public void insert(char c) {
        root.insert(c);
    }

    public void put(String s, T val) {
        root.put(s, val);
    }

    public T get(String s) {
        return root.get(s);
    }

    public static void main(String args[]) {
        Trie<Integer> t = new Trie<>();
        t.put("abc", 0);
        t.put("abd", 1);
        t.put("abe", 2);
        t.put("bad", 3);
        t.put("bac", 4);
        t.put("bed", 5);
        t.put("bedding", 6);
        System.out.println(t.get("a"));
        System.out.println(t.get("abc"));
        System.out.println(t.get("abf"));
    }















}
