package com.keshav.ctci.trees;


import com.keshav.ctci.hash.HashMap;

public class Trie {
    
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(' ');
    }

    public class TrieNode {
        char c;
        HashMap<Character, TrieNode> childMap;
        
        public TrieNode(char c) {
            this.c = c;
            childMap = new HashMap<>();
        }

        public void insert(char x) {
            if (childMap.get(x) != null) return;
            childMap.put(x, new TrieNode(x)); 
        }

        public void insert(String s) {
            if (s.equals("")) return;
            char x = s.charAt(0);
            insert(x);
            if (s.length() > 1)
                childMap.get(x).insert(s.substring(1));
        }
    }

    public void insert(char c) {
        root.insert(c);
    }

    public void insert(String s) {
        root.insert(s);
    }

    public static void main(String args[]) {
        Trie t = new Trie();
        t.insert("abc");
        t.insert("abd");
        t.insert("abe");
        t.insert("bad");
        t.insert("bac");
        t.insert("bed");
        t.insert("bedding");
    }















}
